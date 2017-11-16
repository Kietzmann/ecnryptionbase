package edu.kytsmen.java.encryption.euclidean.dto;

public class NumberInput {
    private int a;
    private int b;

    public NumberInput(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public NumberInput() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
