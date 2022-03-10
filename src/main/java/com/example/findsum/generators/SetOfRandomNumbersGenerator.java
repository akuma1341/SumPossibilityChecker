package com.example.findsum.generators;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SetOfRandomNumbersGenerator implements SetOfNumbersGenerator {
    @Override
    public Set<Integer> generateSetOfNumbers(int capacity) {
        int[] arrayOfNumbers = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            arrayOfNumbers[i] = (int) (Math.random() * 100_000);
        }
        Set<Integer> numbers = new HashSet<>(capacity);
        for (int i = 0; i < capacity; i++) {
            numbers.add(arrayOfNumbers[i]);
        }
        return numbers;
    }
}
