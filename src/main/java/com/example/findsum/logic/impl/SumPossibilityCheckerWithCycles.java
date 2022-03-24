package com.example.findsum.logic.impl;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerWithCycles implements SumPossibilityChecker {

    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        boolean result = false;
        for (Integer firstNumber : numbers) {
            if (result) {
                break;
            }
            for (Integer secondNumber : numbers) {
                if (firstNumber + secondNumber == targetSum) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
