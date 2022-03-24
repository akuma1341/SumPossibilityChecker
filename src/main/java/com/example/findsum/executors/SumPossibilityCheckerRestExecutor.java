package com.example.findsum.executors;

import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.example.findsum.controllers.dto.CheckerResponseDTO;

public interface SumPossibilityCheckerRestExecutor {
    CheckerResponseDTO checkWithCycles(CheckerRequestDTO request);

    CheckerResponseDTO checkWithBinarySearch(CheckerRequestDTO request);

    CheckerResponseDTO checkWithContains(CheckerRequestDTO request);

    CheckerResponseDTO checkWithSet(CheckerRequestDTO request);

    CheckerResponseDTO checkWithAll(CheckerRequestDTO request);
}
