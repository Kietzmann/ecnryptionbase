package edu.kytsmen.java.encryption.schnorr;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SchnorrSign extends SchnorrVerify {
    private final BigInteger privateKey;
    private final SecureRandom random = new SecureRandom();

    public SchnorrSign(byte[] privateKey) {
        super(G.modPow(new BigInteger(positiveIntToTwosCompliment(privateKey)), P));
        this.privateKey = new BigInteger(positiveIntToTwosCompliment(privateKey));
    }

    public SchnorrSignature sign(byte[] message) throws NoSuchAlgorithmException {
        return sign(message, new BigInteger(Q.bitLength() - 1, random));
    }

    public SchnorrSignature sign(byte[] message, BigInteger randomValue)
            throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance(DIGEST_ALGORITHM);

        BigInteger k = randomValue;
        BigInteger r = G.modPow(k, P);

        byte[] rAsBytes = twosComplimentToPositiveInt(r.toByteArray());
        byte[] messageAndR = new byte[message.length + rAsBytes.length];
        System.arraycopy(message, 0, messageAndR, 0, message.length);
        System.arraycopy(rAsBytes, 0, messageAndR, message.length, rAsBytes.length);
        m.update(messageAndR);
        byte[] e = m.digest();

        BigInteger positiveE = new BigInteger(positiveIntToTwosCompliment(e));
        BigInteger s = k.subtract(privateKey.multiply(positiveE)).mod(Q);
        return new SchnorrSignature(twosComplimentToPositiveInt(s.toByteArray()), e, message);
    }
}
