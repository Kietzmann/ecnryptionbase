package edu.kytsmen.java.encryption.schnorr;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SchnorrVerify {


    static final BigInteger P = new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16);
    static final BigInteger Q = new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16);
    static final BigInteger G = new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16);
    static final String DIGEST_ALGORITHM = "SHA-256";
    private final BigInteger publicKey;

    public SchnorrVerify(byte[] publicKey) {
        this.publicKey = new BigInteger(positiveIntToTwosCompliment(publicKey));
    }

    public SchnorrVerify(BigInteger publicKey) {
        this.publicKey = publicKey;
    }

    public static byte[] twosComplimentToPositiveInt(byte[] input) {
        byte[] output = input;
        if (input != null && input.length > 1 && input[0] == 0) {
            output = new byte[input.length - 1];
            System.arraycopy(input, 1, output, 0, output.length);
        }
        return output;
    }

    public static byte[] positiveIntToTwosCompliment(byte[] input) {
        byte[] output = input;
        if (input != null && input.length > 0 && input[0] < 0) {
            output = new byte[input.length + 1];
            System.arraycopy(input, 0, output, 1, input.length);
        }
        return output;
    }

    public byte[] getPublicKey() {
        return twosComplimentToPositiveInt(publicKey.toByteArray());
    }

    public boolean verify(SchnorrSignature sig) throws NoSuchAlgorithmException {

        //r = (pow(self.g, s, self.p) * pow(self.publicKey, e, self.p)) % self.p
        BigInteger e = new BigInteger(positiveIntToTwosCompliment(sig.getE()));
        BigInteger s = new BigInteger(positiveIntToTwosCompliment(sig.getS()));
        BigInteger r = (G.modPow(s, P).multiply(publicKey.modPow(e, P))).mod(P);

        byte[] message = sig.getMessage();
        byte[] rAsBytes = twosComplimentToPositiveInt(r.toByteArray());
        byte[] messageAndR = new byte[message.length + rAsBytes.length];
        System.arraycopy(message, 0, messageAndR, 0, message.length);
        System.arraycopy(rAsBytes, 0, messageAndR, message.length, rAsBytes.length);

        MessageDigest m = MessageDigest.getInstance(DIGEST_ALGORITHM);
        m.update(messageAndR);
        byte[] newE = m.digest();

        return e.equals(new BigInteger(positiveIntToTwosCompliment(newE)));
    }
}
