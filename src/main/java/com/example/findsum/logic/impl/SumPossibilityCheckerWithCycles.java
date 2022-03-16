package com.example.findsum.logic.impl;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerWithCycles implements SumPossibilityChecker {

    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        boolean result = false;
        for (int i = 0; i < numbers.size(); i++) {
            Integer firstNumber = numbers.get(i);
            for (int j = 0; j < numbers.size(); j++) {
                Integer secondNumber = numbers.get(j);
                if (firstNumber + secondNumber == targetSum) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
