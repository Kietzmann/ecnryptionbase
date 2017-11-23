package edu.kytsmen.java.encryption.LCE.dto;

public class NumberInput {
    private final int a;
    private final int b;
    private final int n;

    public NumberInput(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getN() {
        return n;
    }
}
