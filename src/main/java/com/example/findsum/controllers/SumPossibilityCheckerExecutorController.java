package com.example.findsum.controllers;

import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import com.example.findsum.generators.ListOfNumbersGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/index")
@RequiredArgsConstructor
public class SumPossibilityCheckerExecutorController {
    private final SumPossibilityCheckerExecutor executor;
    private final ListOfNumbersGenerator generator;

    private List<Integer> numbers;
    private int capacity = 0;
    private Integer targetSum = 0;
    private boolean result = false;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("numbers", numbers);
        model.addAttribute("capacity", capacity);
        model.addAttribute("sum", targetSum);
        model.addAttribute("result", result);
        return "index";
    }

    @GetMapping("/generateNumbers")
    public String generateNumbers(@RequestParam(name = "capacity", defaultValue = "20") int capacity) {
        this.capacity = capacity;
        this.numbers = generator.generateListOfNumbers(capacity);
        return "redirect:/index";
    }

    @GetMapping("/setTargetSum")
    public String setTargetSum(@RequestParam(name = "sum") int targetSum) {
        this.targetSum = targetSum;
        return "redirect:/index";
    }

    @GetMapping("/clearNumbers")
    public String clearNumbers() {
        numbers.clear();
        return "redirect:/index";
    }

    @GetMapping("/binary")
    public String executeBinarySearch() {
        result = executor.executeCheckerWithBinarySearch(targetSum, numbers);
        return "redirect:/index";
    }

    @GetMapping("/cycles")
    public String executeCycles() {
        result = executor.executeCheckerWithCycles(targetSum, numbers);
        return "redirect:/index";
    }

    @GetMapping("/contains")
    public String executeContains() {
        result = executor.executeCheckerWithContains(targetSum, numbers);
        return "redirect:/index";
    }

    @GetMapping("/all")
    public String executeAll() {
        result = executor.executeAllCheckers(targetSum, numbers);
        return "redirect:/index";
    }
}
