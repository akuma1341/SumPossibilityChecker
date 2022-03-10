package com.example.findsum.executors;

import com.example.findsum.logic.SumPossibilityCheckerWithUniqNumbers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;

@Component
public class SumPossibilityCheckerWithUniqNumbersExecutorImpl implements SumPossibilityCheckerWithUniqNumbersExecutor{
    private final Map<String, SumPossibilityCheckerWithUniqNumbers> checkers;

    public SumPossibilityCheckerWithUniqNumbersExecutorImpl(@Qualifier("checkersWithUniqNumbers") Map<String, SumPossibilityCheckerWithUniqNumbers> checkers) {
        this.checkers = checkers;
    }

    @Override
    public boolean executeCheckerWithCycles(Integer targetSum, Set<Integer> numbers) {
        return checkers.get("cycles").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithBinarySearch(Integer targetSum, Set<Integer> numbers) {
        return checkers.get("binary").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithContains(Integer targetSum, Set<Integer> numbers) {
        return checkers.get("contains").checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeAllCheckers(Integer targetSum, Set<Integer> numbers) {
        return checkers.get("cycles").checkSum(targetSum, numbers) &&
                checkers.get("binary").checkSum(targetSum, numbers) &&
                checkers.get("contains").checkSum(targetSum, numbers);
    }
}
