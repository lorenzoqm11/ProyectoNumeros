package com.numbers.web.app.models;

import java.util.ArrayList;
import java.util.List;

public class NumberModel {
    private List<Integer> numbers = new ArrayList<>();

    public void addNumber(int number) {
        numbers.add(number);
    }

    public List<Integer> getEvenNumbers() {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }

    public int sumEvenNumbers() {
        int sum = 0;
        for (int number : getEvenNumbers()) {
            sum += number;
        }
        return sum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
