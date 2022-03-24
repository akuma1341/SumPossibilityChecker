package com.example.findsum;

import java.util.ArrayList;
import java.util.List;

public class ListOfRandomNumbersGenerator {
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
