package edu.kytsmen.java.encryption.euclidean.core;

public class GCD {
    public static int calculate(int a, int b) {
        if (a == 0) {
            return b;
        }
        return calculate(b % a, a);
    }
}
