package edu.kytsmen.java.encryption.LCE.dto;

public class Result {
    private final int x;

    public Result(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Result: " +
                "x = " + x;
    }
}
