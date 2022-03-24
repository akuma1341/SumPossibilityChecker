package com.example.findsum.executors.impl;

import com.example.findsum.config.CheckerName;
import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import com.example.findsum.logic.SumPossibilityChecker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SumPossibilityCheckerExecutorImpl implements SumPossibilityCheckerExecutor {
    private final Map<CheckerName, SumPossibilityChecker> checkers;

    @Override
    public boolean executeCheckerWithCycles(Integer targetSum, List<Integer> numbers) {
        return checkers.get(CheckerName.CYCLES).checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithBinarySearch(Integer targetSum, List<Integer> numbers) {
        return checkers.get(CheckerName.BINARY).checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithContains(Integer targetSum, List<Integer> numbers) {
        return checkers.get(CheckerName.CONTAINS).checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithSet(Integer targetSum, List<Integer> numbers) {
        return checkers.get(CheckerName.SET).checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeAllCheckers(Integer targetSum, List<Integer> numbers) {
        return checkers.values().stream().allMatch(checker -> checker.checkSum(targetSum, numbers));
    }
}
