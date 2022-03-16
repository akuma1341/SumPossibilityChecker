package com.example.findsum.logic.impl;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SumPossibilityCheckerWithSet implements SumPossibilityChecker {

    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        boolean result = false;
        Set<Integer> uniqNumbers = new HashSet<>(numbers);
        for (Integer number : uniqNumbers) {
            Integer numberToFind = targetSum - number;
            if (uniqNumbers.contains(numberToFind)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
