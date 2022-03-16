package com.example.findsum.controllers;

import com.example.findsum.controllers.dto.ListOfNumbersDTO;
import com.example.findsum.controllers.dto.ResultOfCheckDTO;
import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/executor")
@RequiredArgsConstructor
public class SumPossibilityCheckerExecutorRestController {
    private final SumPossibilityCheckerExecutor executor;

    @GetMapping(value = "/binary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithBinarySearch(@RequestParam("sum") int sum, ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResultOfCheckDTO result = new ResultOfCheckDTO(executor.executeCheckerWithBinarySearch(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/cycles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithCycles(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResultOfCheckDTO result = new ResultOfCheckDTO(executor.executeCheckerWithCycles(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/contains", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithContains(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResultOfCheckDTO result = new ResultOfCheckDTO(executor.executeCheckerWithContains(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/set", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeWithSet(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResultOfCheckDTO result = new ResultOfCheckDTO(executor.executeCheckerWithSet(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResultOfCheckDTO> executeAll(@RequestParam("sum") int sum, @RequestBody ListOfNumbersDTO numbers) {
        if (numbers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        ResultOfCheckDTO result = new ResultOfCheckDTO(executor.executeAllCheckers(sum, numbers.getNumbers()));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
