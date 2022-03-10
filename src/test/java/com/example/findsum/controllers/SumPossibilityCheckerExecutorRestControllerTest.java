package com.example.findsum.controllers;

import com.example.findsum.generators.ListOfNumbersGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    private ListOfNumbersDTO wrapper = new ListOfNumbersDTO();
    private Integer targetSum;

    @BeforeEach
    public void init() {
        numbers = generator.generateListOfNumbers(100);
        wrapper.setNumbers(numbers);
        targetSum = 123;
    }

    @Test
    public void controllerExecutingBinarySearchCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/binary?sum={sum}", targetSum)
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));

    }

    @Test
    public void controllerExecutingCyclesCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/cycles?sum={sum}", targetSum)
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));

    }

    @Test
    public void controllerExecutingContainsCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/contains?sum={sum}", targetSum)
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));

    }

    @Test
    public void controllerExecutingAllCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/all?sum={sum}", targetSum)
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));

    }
}
