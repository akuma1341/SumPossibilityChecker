package com.example.findsum.logic;

import java.util.Set;

public class SumPossibilityCheckerWithUniqNumbersWithContains implements SumPossibilityCheckerWithUniqNumbers{
    @Override
    public boolean checkSum(Integer targetSum, Set<Integer> numbers) {
        for (Integer number : numbers) {
            Integer numberToFind = targetSum - number;
            if (!number.equals(numberToFind)) {
                if (numbers.contains(numberToFind)) {
                    return true;
                }
            }
        }
        return false;
    }
}
