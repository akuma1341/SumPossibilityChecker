package com.example.findsum.executors;

import com.example.findsum.logic.SumPossibilityChecker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SumPossibilityCheckerExecutorImpl implements SumPossibilityCheckerExecutor {
    private final SumPossibilityChecker binarySearch;
    private final SumPossibilityChecker contains;
    private final SumPossibilityChecker cycles;

    public SumPossibilityCheckerExecutorImpl(@Qualifier("sumPossibilityCheckerWithBinarySearch") SumPossibilityChecker binarySearch,
                                             @Qualifier("sumPossibilityCheckerWithContains") SumPossibilityChecker contains,
                                             @Qualifier("sumPossibilityCheckerWithCycles") SumPossibilityChecker cycles) {
        this.binarySearch = binarySearch;
        this.contains = contains;
        this.cycles = cycles;
    }

    @Override
    public boolean executeCheckerWithCycles(Integer targetSum, List<Integer> numbers) {
        return binarySearch.checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithBinarySearch(Integer targetSum, List<Integer> numbers) {
        return contains.checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeCheckerWithContains(Integer targetSum, List<Integer> numbers) {
        return cycles.checkSum(targetSum, numbers);
    }

    @Override
    public boolean executeAllCheckers(Integer targetSum, List<Integer> numbers) {
        if (binarySearch.checkSum(targetSum, numbers) &&
                contains.checkSum(targetSum, numbers) &&
                cycles.checkSum(targetSum, numbers))
            return true;

        return false;
    }
}
