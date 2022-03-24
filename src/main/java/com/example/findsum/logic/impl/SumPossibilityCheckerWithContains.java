package com.example.findsum.logic.impl;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerWithContains implements SumPossibilityChecker {
    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        boolean result = false;
        for (Integer currentNumber : numbers) {
            Integer numberToFind = targetSum - currentNumber;
            if (numbers.contains(numberToFind)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
