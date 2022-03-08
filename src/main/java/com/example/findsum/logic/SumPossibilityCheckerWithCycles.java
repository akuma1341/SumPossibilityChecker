package com.example.findsum.logic;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerWithCycles implements SumPossibilityChecker{
    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            Integer firstNumber = numbers.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                if (j != i) {
                    Integer secondNumber = numbers.get(j);
                    if (firstNumber + secondNumber == targetSum) return true;
                }
            }
        }
        return false;
    }
}
