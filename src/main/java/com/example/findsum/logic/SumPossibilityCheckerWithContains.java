package com.example.findsum.logic;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerWithContains implements SumPossibilityChecker{
    @Override
    public boolean checkSum(Integer targetSum, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            Integer currentNumber = numbers.get(i);
            Integer numberToFind = targetSum - currentNumber;
            if (numbers.indexOf(numberToFind) != i) {
                if (numbers.contains(numberToFind))
                    return true;
            }
        }
        return false;
    }
}
