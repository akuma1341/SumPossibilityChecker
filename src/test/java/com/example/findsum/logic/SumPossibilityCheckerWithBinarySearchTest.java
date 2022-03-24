package com.example.findsum.logic;

import com.example.findsum.ListOfRandomNumbersGenerator;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithBinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SumPossibilityCheckerWithBinarySearchTest {
    private final SumPossibilityChecker checker = new SumPossibilityCheckerWithBinarySearch();
    private final ListOfRandomNumbersGenerator generator = new ListOfRandomNumbersGenerator();
    private final List<Integer> numbers = generator.generateListOfNumbers(100_000);
    private final Integer targetSum = 10;

    @Test
    public void checkSum() {
        Assertions.assertTrue(checker.checkSum(targetSum, numbers));
    }

    @Test
    public void testNumbersIsEmpty() {
        Assertions.assertTrue(numbers.isEmpty());
    }
}