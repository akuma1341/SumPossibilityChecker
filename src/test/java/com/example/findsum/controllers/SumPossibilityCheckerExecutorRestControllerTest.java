package com.example.findsum.controllers;

import com.example.findsum.ListOfRandomNumbersGenerator;
import com.example.findsum.controllers.dto.CheckerRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private MockMvc mockMvc;

    private final ListOfRandomNumbersGenerator generator = new ListOfRandomNumbersGenerator();
    private final List<Integer> numbers = generator.generateListOfNumbers(100);
    private final Integer targetSum = 123;
    private final CheckerRequestDTO wrapper = new CheckerRequestDTO(targetSum, numbers);

    @Test
    public void controllerExecutingBinarySearchCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/binary")
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));
    }

    @Test
    public void controllerExecutingCyclesCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/cycles")
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));
    }

    @Test
    public void controllerExecutingContainsCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/contains")
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));
    }

    @Test
    public void controllerExecutingAllCheckReturnStatus200AndTrueResult() throws Exception {
        mockMvc.perform(
                get("/api/v1/executor/all")
                        .content(mapper.writeValueAsString(wrapper))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(true));
    }
}
