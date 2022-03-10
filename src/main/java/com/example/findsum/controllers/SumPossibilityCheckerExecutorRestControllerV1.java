package com.example.findsum.controllers;

import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/executor")
@RequiredArgsConstructor
public class SumPossibilityCheckerExecutorRestControllerV1 {
    private final SumPossibilityCheckerExecutor executor;
    private final ResultOfCheckWrapper result;

    @GetMapping(value = "/binary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckWrapper> executeWithBinarySearch(@RequestParam("sum") int sum, @RequestBody ListOfNumbersWrapper numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithBinarySearch(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "cycles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckWrapper> executeWithCycles(@RequestParam("sum") int sum, @RequestBody ListOfNumbersWrapper numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithCycles(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "contains", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckWrapper> executeWithContains(@RequestParam("sum") int sum, @RequestBody ListOfNumbersWrapper numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithContains(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckWrapper> executeAll(@RequestParam("sum") int sum, @RequestBody ListOfNumbersWrapper numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeAllCheckers(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
