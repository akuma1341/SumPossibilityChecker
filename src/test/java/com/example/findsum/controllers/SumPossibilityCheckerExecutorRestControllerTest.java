package com.example.findsum.controllers;

import com.example.findsum.executors.SumPossibilityCheckerExecutor;
import com.example.findsum.generators.ListOfNumbersGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class SumPossibilityCheckerExecutorRestControllerTest {
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ListOfNumbersGenerator generator;
    @Autowired
    private MockMvc mockMvc;

    private List<Integer> numbers;
    private ListOfNumbersWrapper wrapper = new ListOfNumbersWrapper();
    private Integer targetSum;

    @BeforeEach
    public void init() {
        numbers = generator.generateListOfNumbers(100);
        wrapper.setNumbers(numbers);
        targetSum = 123;
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/binary?sum={sum}", targetSum)
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));

    }
}