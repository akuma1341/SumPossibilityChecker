package com.example.findsum.logic;

import java.util.Set;

public class SumPossibilityCheckerWithUniqNumbersWithCycles implements SumPossibilityCheckerWithUniqNumbers{
    @Override
    public boolean checkSum(Integer targetSum, Set<Integer> numbers) {
        for (Integer firstNumber : numbers) {
            for (Integer secondNumber : numbers) {
                if (!firstNumber.equals(secondNumber)) {
                    if (firstNumber + secondNumber == targetSum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
