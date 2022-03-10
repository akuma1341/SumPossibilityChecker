package com.example.findsum.controllers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListOfNumbersDTO {
    private List<Integer> numbers;

    public ListOfNumbersDTO() {
        numbers = new ArrayList<>();
    }
}
