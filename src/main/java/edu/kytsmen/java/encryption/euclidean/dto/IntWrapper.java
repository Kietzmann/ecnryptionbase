package edu.kytsmen.java.encryption.euclidean.dto;

public class IntWrapper {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static IntWrapper build(int value) {
        IntWrapper intWrapper = new IntWrapper();
        intWrapper.setValue(value);
        return intWrapper;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
