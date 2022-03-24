package com.example.findsum.logic.impl;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SumPossibilityCheckerWithBinarySearch implements SumPossibilityChecker {

    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        boolean result = false;
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        for (Integer currentNumber : numbers) {
            Integer numberToFind = targetSum - currentNumber;
            if (binarySearch(sortedNumbers, numberToFind) >= 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> numbers, Integer key) {
        int low = 0;
        int high = numbers.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            int midVal = numbers.get(mid);

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
