package com.example.findsum.executors;

import java.util.Set;

public interface SumPossibilityCheckerWithUniqNumbersExecutor {
    boolean executeCheckerWithCycles(Integer targetSum, Set<Integer> numbers);

    boolean executeCheckerWithBinarySearch(Integer targetSum, Set<Integer> numbers);

    boolean executeCheckerWithContains(Integer targetSum, Set<Integer> numbers);

    boolean executeAllCheckers(Integer targetSum, Set<Integer> numbers);
}
