package com.example.findsum.logic;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SumPossibilityCheckerWithBinarySearch implements SumPossibilityChecker {
    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        long before = System.currentTimeMillis();
        List<Integer> sortedNumbers = numbers.stream().sorted().collect(Collectors.toList());
        long after = System.currentTimeMillis();
        System.out.println("List copied in " + (after - before));
        for (int i = 0; i < sortedNumbers.size(); i++) {
            Integer currentNumber = sortedNumbers.get(i);
            Integer numberToFind = targetSum - currentNumber;
            if (binarySearch(sortedNumbers, numberToFind, i) >= 0) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(List<Integer> numbers, Integer key, int exceptIndex) {
        int low = 0;
        int high = numbers.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;

            if (mid != exceptIndex) {
                int midVal = numbers.get(mid);

                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid; // key found
            } else low = mid + 1;
        }
        return -(low + 1);  // key not found.
    }
}
