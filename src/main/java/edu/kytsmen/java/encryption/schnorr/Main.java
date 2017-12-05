package edu.kytsmen.java.encryption.schnorr;

import java.math.BigInteger;
import java.util.Objects;

import static edu.kytsmen.java.encryption.schnorr.SchnorrVerify.positiveIntToTwosCompliment;

public class Main {
    private static SchnorrSignTestCase[] test = {
            new SchnorrSignTestCase("password", "message", "1",
                    "dd8291f5bbef43c83d35acd6d2592648f0fed44ed655f5b2b346cb1b35c7fac4",
                    "72d740a9bba48c30e6bd56a58affd5361e787c0c"
            )};

    public static void main(String[] args) throws Exception {
        for (SchnorrSignTestCase t : test) {
            SchnorrSign signer = new SchnorrSign(t.password.getBytes());
            SchnorrSignature sign = signer.sign(t.message.getBytes(), t.random);
            BigInteger e = new BigInteger(positiveIntToTwosCompliment(sign.getE()));
            BigInteger s = new BigInteger(positiveIntToTwosCompliment(sign.getS()));
            System.out.println(Objects.equals(t.e, e) && Objects.equals(t.s, s));
        }
    }

    private static class SchnorrSignTestCase {
        String password;
        String message;
        BigInteger random;
        BigInteger e;
        BigInteger s;

        SchnorrSignTestCase(String password, String message, String random, String e, String s) {
            this.password = password;
            this.message = message;
            this.random = new BigInteger(random, 16);
            this.e = new BigInteger(e, 16);
            this.s = new BigInteger(s, 16);
        }

        @Override
        public String toString() {
            return "{\n " + password + ",\n " + message + ",\n "
                    + random + ",\n " + e + ",\n " + s + "\n}";
        }
    }
}
