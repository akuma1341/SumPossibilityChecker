package com.example.findsum.logic;

import com.example.findsum.logic.impl.SumPossibilityCheckerWithContains;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SumPossibilityCheckerWithContainsTest {
    private final SumPossibilityChecker checker = new SumPossibilityCheckerWithContains();

    @Test
    public void checkSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer targetSum = 10;

        Assertions.assertTrue(checker.checkSum(targetSum, numbers));
    }
}