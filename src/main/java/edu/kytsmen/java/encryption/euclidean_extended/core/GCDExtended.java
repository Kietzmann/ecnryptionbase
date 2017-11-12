package edu.kytsmen.java.encryption.euclidean_extended.core;

import edu.kytsmen.java.encryption.euclidean_extended.utils.IntWrapper;
import org.apache.commons.lang3.mutable.MutableInt;

public class GCDExtended {
    public static int calculate(int a, int b, IntWrapper x, IntWrapper y) {
        if (a == 0) {
            x.setValue(0);
            y.setValue(1);
            return b;
        }

        IntWrapper x1 = IntWrapper.set(1);
        IntWrapper y1 = IntWrapper.set(1);
        int gcd = calculate(b % a, a, x1, y1);
        x.setValue(y1.getValue() - (b / a) * x1.getValue());
        y.setValue(x1.getValue());

        return gcd;
    }
}
