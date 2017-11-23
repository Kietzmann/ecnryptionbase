package edu.kytsmen.java.encryption.euclidean.extended.core;

import edu.kytsmen.java.encryption.euclidean.dto.result.ExtendedResult;
import edu.kytsmen.java.encryption.euclidean.dto.IntWrapper;
import edu.kytsmen.java.encryption.euclidean.dto.NumberInput;

public class GCDExtended {
    private static int calculate(int a, int b, IntWrapper x, IntWrapper y) {
        if (a == 0) {
            x.setValue(0);
            y.setValue(1);
            return b;
        }

        IntWrapper x1 = IntWrapper.build(1);
        IntWrapper y1 = IntWrapper.build(1);
        int gcd = calculate(b % a, a, x1, y1);
        x.setValue(y1.getValue() - (b / a) * x1.getValue());
        y.setValue(x1.getValue());

        return gcd;
    }

    public static ExtendedResult calculate(NumberInput input) {
        IntWrapper x = IntWrapper.build(1);
        IntWrapper y = IntWrapper.build(1);
        int gcd = calculate(input.getA(), input.getB(), x, y);
        return new ExtendedResult(gcd, x.getValue(), y.getValue());
    }
}
