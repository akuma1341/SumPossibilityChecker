package com.example.findsum.executors.impl;

import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.example.findsum.controllers.dto.CheckerResponseDTO;
import com.example.findsum.executors.SumPossibilityCheckerRestExecutor;
import com.example.findsum.logic.SumPossibilityChecker;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithBinarySearch;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithContains;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithCycles;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithSet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SumPossibilityCheckerRestExecutorImpl implements SumPossibilityCheckerRestExecutor {
    private final List<SumPossibilityChecker> checkers;

    @Override
    public CheckerResponseDTO checkWithCycles(CheckerRequestDTO request) {
        return new CheckerResponseDTO(checkers.stream()
                .filter(checker -> checker instanceof SumPossibilityCheckerWithCycles)
                .allMatch(checker -> checker.checkSum(request.getTargetSum(), request.getNumbers())));
    }

    @Override
    public CheckerResponseDTO checkWithBinarySearch(CheckerRequestDTO request) {
        return new CheckerResponseDTO(checkers.stream()
                .filter(checker -> checker instanceof SumPossibilityCheckerWithBinarySearch)
                .allMatch(checker -> checker.checkSum(request.getTargetSum(), request.getNumbers())));
    }

    @Override
    public CheckerResponseDTO checkWithContains(CheckerRequestDTO request) {
        return new CheckerResponseDTO(checkers.stream()
                .filter(checker -> checker instanceof SumPossibilityCheckerWithContains)
                .allMatch(checker -> checker.checkSum(request.getTargetSum(), request.getNumbers())));
    }

    @Override
    public CheckerResponseDTO checkWithSet(CheckerRequestDTO request) {
        return new CheckerResponseDTO(checkers.stream()
                .filter(checker -> checker instanceof SumPossibilityCheckerWithSet)
                .allMatch(checker -> checker.checkSum(request.getTargetSum(), request.getNumbers())));
    }

    @Override
    public CheckerResponseDTO checkWithAll(CheckerRequestDTO request) {
        return new CheckerResponseDTO(checkers.stream()
                .allMatch(checker -> checker.checkSum(request.getTargetSum(), request.getNumbers())));
    }
}
