package com.example.findsum.logic;

import com.example.findsum.generators.ListOfNumbersGenerator;
import com.example.findsum.generators.ListOfRandomNumbersGenerator;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithBinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SumPossibilityCheckerWithBinarySearchTest {
    private final SumPossibilityChecker checker = new SumPossibilityCheckerWithBinarySearch();
    private final ListOfNumbersGenerator generator = new ListOfRandomNumbersGenerator();

    private List<Integer> numbers;
    private Integer targetSum;

    @BeforeEach
    public void init() {
        numbers = generator.generateListOfNumbers(100_000);
        targetSum = 10;
    }

    @Test
    public void checkSum() {
        Assertions.assertTrue(checker.checkSum(targetSum, numbers));
    }

    @Test
    public void testNumbersIsEmpty() {
        Assertions.assertTrue(numbers.isEmpty());
    }
}