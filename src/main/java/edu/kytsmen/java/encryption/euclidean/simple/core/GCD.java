package edu.kytsmen.java.encryption.euclidean.simple.core;

import edu.kytsmen.java.encryption.euclidean.dto.NumberInput;
import edu.kytsmen.java.encryption.euclidean.dto.result.Result;

public class GCD {
    private static int calculate(int a, int b) {
        if (a == 0) {
            return b;
        }
        return calculate(b % a, a);
    }

    public static Result calculate(NumberInput input) {
        int gcd = calculate(input.getA(), input.getB());
        return new Result(gcd);
    }
}
