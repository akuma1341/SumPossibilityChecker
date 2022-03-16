package com.example.findsum.executors;

import java.util.List;

public interface SumPossibilityCheckerExecutor {
    boolean executeCheckerWithCycles(Integer targetSum, List<Integer> numbers);

    boolean executeCheckerWithBinarySearch(Integer targetSum, List<Integer> numbers);

    boolean executeCheckerWithContains(Integer targetSum, List<Integer> numbers);

    boolean executeCheckerWithSet(Integer targetSum, List<Integer> numbers);

    boolean executeAllCheckers(Integer targetSum, List<Integer> numbers);
}
