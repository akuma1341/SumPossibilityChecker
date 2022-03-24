package com.example.findsum.controllers;

import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.example.findsum.controllers.dto.CheckerResponseDTO;
import com.example.findsum.executors.SumPossibilityCheckerRestExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/restExecutor")
@RequiredArgsConstructor
public class SumPossibilityCheckerRestExecutorController {
    private final SumPossibilityCheckerRestExecutor executor;

    @GetMapping(value = "/binary", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithBinarySearch(@RequestBody CheckerRequestDTO numbers) {
        return executor.checkWithBinarySearch(numbers);
    }

    @GetMapping(value = "/cycles", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithCycles(@RequestBody CheckerRequestDTO numbers) {
        return executor.checkWithCycles(numbers);
    }

    @GetMapping(value = "/contains", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithContains(@RequestBody CheckerRequestDTO numbers) {
        return executor.checkWithContains(numbers);
    }

    @GetMapping(value = "/set", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeWithSet(@RequestBody CheckerRequestDTO numbers) {
        return executor.checkWithSet(numbers);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CheckerResponseDTO executeAll(@RequestBody CheckerRequestDTO numbers) {
        return executor.checkWithAll(numbers);
    }
}
