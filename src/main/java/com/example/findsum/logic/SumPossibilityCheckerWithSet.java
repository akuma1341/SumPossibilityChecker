package com.example.findsum.logic;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class SumPossibilityCheckerWithSet implements SumPossibilityChecker{
    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        Set<Integer> uniqNumbers = new HashSet<>(numbers);
        for (Integer number : uniqNumbers) {
            Integer numberToFind = targetSum - number;
            if (!number.equals(numberToFind)) {
                if (uniqNumbers.contains(numberToFind)) {
                    return true;
                }
            }
        }
        return false;
    }
}
