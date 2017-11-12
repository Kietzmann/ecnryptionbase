package edu.kytsmen.java.encryption.eratosthenes;

import edu.kytsmen.java.encryption.eratosthenes.core.SieveManager;

public class Main {
    public static void main(String[] args) {
        int n = 33;
        for (int i : SieveManager.sieveOfEratosthenes(n)) {
            System.out.println(i);
        }
    }
}
