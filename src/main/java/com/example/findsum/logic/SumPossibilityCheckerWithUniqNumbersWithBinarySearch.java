package com.example.findsum.logic;

import java.util.Set;

public class SumPossibilityCheckerWithUniqNumbersWithBinarySearch implements SumPossibilityCheckerWithUniqNumbers{
    @Override
    public boolean checkSum(Integer targetSum, Set<Integer> numbers) {
//        for (Integer number : numbers) {
//            Integer numberToFind = targetSum - number;
//            if (binarySearch(numbers, numberToFind) >= 0) {
//                return true;
//            }
//        }
        return false;
    }

//    private int binarySearch(Set<Integer> numbers, Integer key) {
//        int low = 0;
//        int high = numbers.size() - 1;
//
//        while (low <= high) {
//            int mid = (low + high) >>> 1;
//                int midVal = numbers.get(mid);
//
//                if (midVal < key)
//                    low = mid + 1;
//                else if (midVal > key)
//                    high = mid - 1;
//                else
//                    return mid; // key found
//        }
//        return -(low + 1);  // key not found.
//    }
}