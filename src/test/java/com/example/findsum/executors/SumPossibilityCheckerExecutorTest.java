package com.example.findsum.executors;

import com.example.findsum.generators.ListOfNumbersGenerator;
import com.example.findsum.logic.SumPossibilityChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SumPossibilityCheckerExecutorTest {
    @Autowired
    private ListOfNumbersGenerator generator;

    @Autowired
    private SumPossibilityCheckerExecutor executor;

    private List<Integer> numbers;
    private Integer targetSum;

    @BeforeEach
    void init() {
        numbers = generator.generateListOfNumbers(100_000_000);
        targetSum = 10;
    }

    @Test
    public void executeCheckerWithCycles() {
        System.out.println("This is cycles");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println(executor.executeCheckerWithCycles(targetSum, numbers));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));
    }

    @Test
    public void executeCheckerWithBinarySearch() {
        System.out.println("This is binary search");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println(executor.executeCheckerWithBinarySearch(targetSum, numbers));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));
    }

    @Test
    public void executeCheckerWithContains() {
        System.out.println("This is contains");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println(executor.executeCheckerWithContains(targetSum, numbers));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));
    }

    @Test
    public void executeCheckerWithSet() {
        System.out.println("This is set");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println(executor.executeCheckerWithSet(targetSum, numbers));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));
    }

    @Test
    public void executeAllCheckers() {
        System.out.println("This is all");
        long timeBeforeStart = System.currentTimeMillis();
        System.out.println(executor.executeAllCheckers(targetSum, numbers));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));
    }

    @Test
    public void resultOfCheckerWithCyclesIsFalse() {
        Assertions.assertFalse(executor.executeCheckerWithCycles(targetSum, numbers));
    }

    @Test
    public void resultOfCheckerWithBinarySearchIsFalse() {
        Assertions.assertFalse(executor.executeCheckerWithBinarySearch(targetSum, numbers));
    }

    @Test
    public void resultOfCheckerWithContainsIsFalse() {
        Assertions.assertFalse(executor.executeCheckerWithContains(targetSum, numbers));
    }

    @Test
    public void resultOfAllCheckerIsFalse() {
        Assertions.assertFalse(executor.executeAllCheckers(targetSum, numbers));
    }

    @Test
    public void numbersListIsEmpty() {
        Assertions.assertTrue(numbers.isEmpty());
    }

    @Test
    public void numbersListIsNull() {
        Assertions.assertNull(numbers);
    }

    @Test
    public void numbersAreNotNull() {
        for (Integer number : numbers) {
            Assertions.assertNotNull(number);
        }
    }
}