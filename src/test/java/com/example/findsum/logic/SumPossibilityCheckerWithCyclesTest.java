package com.example.findsum.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumPossibilityCheckerWithCyclesTest {
    private final SumPossibilityChecker checker = new SumPossibilityCheckerWithCycles();

    @Test
    public void checkSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer targetSum = 10;

        Assertions.assertTrue(checker.checkSum(targetSum, numbers));
    }
}