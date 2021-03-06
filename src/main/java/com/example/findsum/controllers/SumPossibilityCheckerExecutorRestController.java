package com.example.findsum.controllers;

import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.example.findsum.controllers.dto.CheckerResponseDTO;
import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/executor")
@RequiredArgsConstructor
public class SumPossibilityCheckerExecutorRestController {
    private final SumPossibilityCheckerExecutor executor;

    @GetMapping(value = "/binary", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithBinarySearch(@RequestBody CheckerRequestDTO numbers) {
        boolean checkerResult = executor.executeCheckerWithBinarySearch(numbers.getTargetSum(), numbers.getNumbers());
        return new CheckerResponseDTO(checkerResult);
    }

    @GetMapping(value = "/cycles", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithCycles(@RequestBody CheckerRequestDTO numbers) {
        boolean checkerResult = executor.executeCheckerWithCycles(numbers.getTargetSum(), numbers.getNumbers());
        return new CheckerResponseDTO(checkerResult);
    }

    @GetMapping(value = "/contains", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithContains(@RequestBody CheckerRequestDTO numbers) {
        boolean checkerResult = executor.executeCheckerWithContains(numbers.getTargetSum(), numbers.getNumbers());
        return new CheckerResponseDTO(checkerResult);
    }

    @GetMapping(value = "/set", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithSet(@RequestBody CheckerRequestDTO numbers) {
        boolean checkerResult = executor.executeCheckerWithSet(numbers.getTargetSum(), numbers.getNumbers());
        return new CheckerResponseDTO(checkerResult);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeAll(@RequestBody CheckerRequestDTO numbers) {
        boolean checkerResult = executor.executeAllCheckers(numbers.getTargetSum(), numbers.getNumbers());
        return new CheckerResponseDTO(checkerResult);
    }
}
