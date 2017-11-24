package edu.kytsmen.java.encryption.hashsums;

import edu.kytsmen.java.encryption.hashsums.core.dstu7564.DSTU7564;
import edu.kytsmen.java.encryption.hashsums.core.sha3.Keccak;

import static edu.kytsmen.java.encryption.hashsums.core.sha3.Parameters.*;
import static edu.kytsmen.java.encryption.hashsums.core.sha3.utils.HexUtils.getHex;

public class Main {
    public static void main(String[] args) {
        String s = getHex("The quick brown fox jumps over the lazy dog".getBytes());

        Keccak keccak = new Keccak();
        byte[] hash = new byte[512 / 8];
        DSTU7564 dstu7564 = new DSTU7564(512);
        dstu7564.update(s.getBytes(), 0, s.getBytes().length);
        dstu7564.doFinal(hash, 0);
        for (byte b : hash) {
            System.out.print(b);
        }
        System.out.println();

        System.out.println("keccak-224 = " + keccak.getHash(s, KECCAK_224));
        System.out.println("keccak-256 = " + keccak.getHash(s, KECCAK_256));
        System.out.println("keccak-384 = " + keccak.getHash(s, KECCAK_384));
        System.out.println("keccak-512 = " + keccak.getHash(s, KECCAK_512));

        System.out.println("sha3-224 = " + keccak.getHash(s, SHA3_224));
        System.out.println("sha3-256 = " + keccak.getHash(s, SHA3_256));
        System.out.println("sha3-384 = " + keccak.getHash(s, SHA3_384));
        System.out.println("sha3-512 = " + keccak.getHash(s, SHA3_512));

        System.out.println("shake128 = " + keccak.getHash(s, SHAKE128));
        System.out.println("shake256 = " + keccak.getHash(s, SHAKE256));
    }
}
