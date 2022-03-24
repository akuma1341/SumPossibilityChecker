package com.example.findsum.config;

import com.example.findsum.logic.SumPossibilityChecker;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithBinarySearch;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithContains;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithCycles;
import com.example.findsum.logic.impl.SumPossibilityCheckerWithSet;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class ExecutorConfig {
    private final SumPossibilityCheckerWithBinarySearch binarySearch;
    private final SumPossibilityCheckerWithCycles cycles;
    private final SumPossibilityCheckerWithContains contains;
    private final SumPossibilityCheckerWithSet set;

    @Bean
    public Map<CheckerName, SumPossibilityChecker> checkers() {
        Map<CheckerName, SumPossibilityChecker> result = new HashMap<>();
        result.put(CheckerName.BINARY, binarySearch);
        result.put(CheckerName.CYCLES, cycles);
        result.put(CheckerName.CONTAINS, contains);
        result.put(CheckerName.SET, set);
        return result;
    }
}
