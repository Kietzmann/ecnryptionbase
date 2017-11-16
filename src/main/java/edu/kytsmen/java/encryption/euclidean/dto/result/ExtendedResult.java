package edu.kytsmen.java.encryption.euclidean.dto.result;

public class ExtendedResult extends Result{
    private int x;
    private int y;

    public ExtendedResult(int gcd, int x, int y) {
        super(gcd);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Result: " +
                "gcd=" + gcd +
                ", x=" + x +
                ", y=" + y;
    }
}
