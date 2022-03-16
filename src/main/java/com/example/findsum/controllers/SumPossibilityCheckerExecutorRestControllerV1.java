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
    private final ResultOfCheckDTO result;

    @GetMapping(value = "/binary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestExecutorDataDTO.Response.ResultOfCheck> executeWithBinarySearch(@RequestParam("sum") int sum,
                                                                                              @RequestBody TestExecutorDataDTO.Request.Check numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var result = new TestExecutorDataDTO.Response.ResultOfCheck(executor.executeCheckerWithBinarySearch(sum, numbers.getNumbers()));
//        result.setResult(executor.executeCheckerWithBinarySearch(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "cycles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithCycles(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithCycles(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "contains", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithContains(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithContains(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithSet(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeCheckerWithSet(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeAll(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        result.setResult(executor.executeAllCheckers(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
