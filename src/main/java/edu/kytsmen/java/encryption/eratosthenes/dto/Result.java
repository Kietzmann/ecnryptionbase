package edu.kytsmen.java.encryption.eratosthenes.dto;

import java.util.Arrays;

public class Result {
    private final int [] value;

    public Result(int[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result " + Arrays.toString(value);
    }
}
