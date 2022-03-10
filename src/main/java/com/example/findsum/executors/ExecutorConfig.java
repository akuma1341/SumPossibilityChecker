package com.example.findsum.executors;

import com.example.findsum.logic.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ExecutorConfig {

    @Bean
    public Map<String, SumPossibilityChecker> checkers() {
        Map<String, SumPossibilityChecker> result = new HashMap<>();
        result.put("binary", new SumPossibilityCheckerWithBinarySearch());
        result.put("cycles", new SumPossibilityCheckerWithCycles());
        result.put("contains", new SumPossibilityCheckerWithContains());
        return result;
    }

    @Bean
    public Map<String, SumPossibilityCheckerWithUniqNumbers> checkersWithUniqNumbers() {
        Map<String, SumPossibilityCheckerWithUniqNumbers> result = new HashMap<>();
        result.put("binary", new SumPossibilityCheckerWithUniqNumbersWithBinarySearch());
        result.put("cycles", new SumPossibilityCheckerWithUniqNumbersWithCycles());
        result.put("contains", new SumPossibilityCheckerWithUniqNumbersWithContains());
        return result;
    }
}
