package com.example.findsum.generators;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListOfRandomNumbersGenerator implements ListOfNumbersGenerator{
    @Override
    public List<Integer> generateListOfNumbers(int capacity) {
        int[] arrayOfNumbers = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arrayOfNumbers[i] = (int) (Math.random() * 100);
        }
        List<Integer> numbers = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            numbers.add(arrayOfNumbers[i]);
        }
        return numbers;
    }
}
