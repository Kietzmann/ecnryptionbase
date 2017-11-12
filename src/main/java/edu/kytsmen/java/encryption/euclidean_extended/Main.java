package edu.kytsmen.java.encryption.euclidean_extended;

import edu.kytsmen.java.encryption.euclidean_extended.core.GCDExtended;
import edu.kytsmen.java.encryption.euclidean_extended.utils.IntWrapper;

public class Main {
    public static void main(String[] args) {
        IntWrapper x = IntWrapper.set(1);
        IntWrapper y = IntWrapper.set(1);
        int a = 125;
        int b = 3;
        int gcd = GCDExtended.calculate(a, b, x, y);
        System.out.println(gcd);
        System.out.println(x);
        System.out.println(y);
    }
}
