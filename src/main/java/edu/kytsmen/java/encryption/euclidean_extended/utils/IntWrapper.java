package edu.kytsmen.java.encryption.euclidean_extended.utils;

public class IntWrapper {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static IntWrapper set(int value) {
        IntWrapper intWrapper = new IntWrapper();
        intWrapper.setValue(value);
        return intWrapper;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
