package com.example.findsum.logic;

import java.util.Set;

public class SumPossibilityCheckerWithUniqNumbersWithBinarySearch implements SumPossibilityCheckerWithUniqNumbers {
    @Override
    public boolean checkSum(Integer targetSum, Set<Integer> numbers) {
        Integer[] numbersForSearch = numbers.toArray(new Integer[0]);
        for (Integer number : numbers) {
            Integer numberToFind = targetSum - number;
            if (binarySearch(numbersForSearch, numberToFind, number) >= 0) {
                return true;
            }
        }
        return false;
    }

    private int binarySearch(Integer[] numbers, Integer key, Integer exceptNumber) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = numbers[mid];

            if (midVal != exceptNumber) {
                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid; // key found
            } else {
                low = mid + 1;
            }
        }
        return -(low + 1);  // key not found.
    }
}
