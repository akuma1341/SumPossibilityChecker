package com.example.findsum.controllers;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListOfNumbersWrapper {
    private List<Integer> numbers;

    public ListOfNumbersWrapper() {
        numbers = new ArrayList<>();
    }
}
