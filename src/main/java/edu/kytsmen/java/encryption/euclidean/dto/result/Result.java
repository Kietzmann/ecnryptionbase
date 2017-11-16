package edu.kytsmen.java.encryption.euclidean.dto.result;

public class Result {
    protected int gcd;

    public Result(int gcd) {
        this.gcd = gcd;
    }

    @Override
    public String toString() {
        return "Result " +
                "gcd=" + gcd;
    }
}
