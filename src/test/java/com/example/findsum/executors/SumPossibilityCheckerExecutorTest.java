package com.example.findsum.executors;

import com.example.findsum.ListOfRandomNumbersGenerator;
import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.example.findsum.controllers.dto.CheckerResponseDTO;
import com.example.findsum.logic.SumPossibilityChecker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SumPossibilityCheckerExecutorTest {
    @Autowired
    private List<SumPossibilityChecker> checkers;
    @Autowired
    private SumPossibilityCheckerExecutor executor;
    @Autowired
    private SumPossibilityCheckerRestExecutor restExecutor;

    private final ListOfRandomNumbersGenerator generator = new ListOfRandomNumbersGenerator();
    private final List<Integer> numbers = generator.generateListOfNumbers(100_000_000);
    private final Integer targetSum = 10;

    @Test
    public void streamTest() {
        long timeBeforeStart = System.currentTimeMillis();
        boolean match = numbers.stream()
                .anyMatch(n -> n == (targetSum - n));
        long timeAfterStart = System.currentTimeMillis();
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(match);
    }


    @Test
    public void executeRestChecker() {
        CheckerRequestDTO request = new CheckerRequestDTO(targetSum, numbers);
        System.out.println("This is cycles");
        long timeBeforeStart = System.currentTimeMillis();
        CheckerResponseDTO response = restExecutor.checkWithCycles(request);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(response.isMatchFound());
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(response.isMatchFound());
    }


    @Test
    public void showCheckers() {
        System.out.println(checkers.size());
        for (SumPossibilityChecker checker : checkers) {
            System.out.println(checker);
            long start = System.currentTimeMillis();
            System.out.println(checker.checkSum(targetSum, numbers));
            System.out.println("Time spent: " + (System.currentTimeMillis() - start));
        }
    }

    @Test
    public void executeCheckerWithCycles() {
        System.out.println("This is cycles");
        long timeBeforeStart = System.currentTimeMillis();
        boolean result = executor.executeCheckerWithCycles(targetSum, numbers);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(result);
    }

    @Test
    public void executeCheckerWithBinarySearch() {
        System.out.println("This is binary search");
        long timeBeforeStart = System.currentTimeMillis();
        boolean result = executor.executeCheckerWithBinarySearch(targetSum, numbers);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(result);
    }

    @Test
    public void executeCheckerWithContains() {
        System.out.println("This is contains");
        long timeBeforeStart = System.currentTimeMillis();
        boolean result = executor.executeCheckerWithContains(targetSum, numbers);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(result);
    }

    @Test
    public void executeCheckerWithSet() {
        System.out.println("This is set");
        long timeBeforeStart = System.currentTimeMillis();
        boolean result = executor.executeCheckerWithSet(targetSum, numbers);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(result);
    }

    @Test
    public void executeAllCheckers() {
        System.out.println("This is all");
        long timeBeforeStart = System.currentTimeMillis();
        boolean result = executor.executeAllCheckers(targetSum, numbers);
        long timeAfterStart = System.currentTimeMillis();

        System.out.println(result);
        System.out.println("Time spent: " + (timeAfterStart - timeBeforeStart));

        assertTrue(result);
    }

    @Test
    public void resultOfCheckerWithCyclesIsFalse() {
        boolean result = executor.executeCheckerWithCycles(targetSum, numbers);

        assertFalse(result);
    }

    @Test
    public void resultOfCheckerWithBinarySearchIsFalse() {
        boolean result = executor.executeCheckerWithBinarySearch(targetSum, numbers);

        assertFalse(result);
    }

    @Test
    public void resultOfCheckerWithContainsIsFalse() {
        boolean result = executor.executeCheckerWithContains(targetSum, numbers);

        assertFalse(result);
    }

    @Test
    public void resultOfAllCheckerIsFalse() {
        boolean result = executor.executeAllCheckers(targetSum, numbers);

        assertFalse(result);
    }

    @Test
    public void numbersListIsEmpty() {
        assertTrue(numbers.isEmpty());
    }

    @Test
    public void numbersListIsNull() {
        assertNull(numbers);
    }

    @Test
    public void numbersAreNotNull() {
        for (Integer number : numbers) {
            assertNotNull(number);
        }
    }
}