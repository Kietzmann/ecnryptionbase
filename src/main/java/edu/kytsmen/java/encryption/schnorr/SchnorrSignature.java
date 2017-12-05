package edu.kytsmen.java.encryption.schnorr;

public class SchnorrSignature {
    private final byte[] s;
    private final byte[] e;
    private final byte[] message;

    public SchnorrSignature(byte[] s, byte[] e, byte[] message) {
        this.s = s;
        this.e = e;
        this.message = message;
    }

    public byte[] getS() {
        return s;
    }

    public byte[] getE() {
        return e;
    }

    public byte[] getMessage() {
        return message;
    }
}
