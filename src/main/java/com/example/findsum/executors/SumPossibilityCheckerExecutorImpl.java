package com.example.findsum.executors;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SumPossibilityCheckerExecutorImpl implements SumPossibilityCheckerExecutor {
    private final Map<String, SumPossibilityChecker> checkers;

    public SumPossibilityCheckerExecutorImpl(@Qualifier("checkers") Map<String, SumPossibilityChecker> checkers) {
        this.checkers = checkers;
    }

    @Override
    public boolean executeCheckerWithCycles(Integer targetSum, List<Integer> numbers) {
        return checkers.get("cycles").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithBinarySearch(Integer targetSum, List<Integer> numbers) {
        return checkers.get("binary").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithContains(Integer targetSum, List<Integer> numbers) {
        return checkers.get("contains").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeAllCheckers(Integer targetSum, List<Integer> numbers) {
        return checkers.get("cycles").checkSum(targetSum, numbers) &&
                checkers.get("binary").checkSum(targetSum, numbers) &&
                checkers.get("contains").checkSum(targetSum, numbers);
    }
}
