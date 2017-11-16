package edu.kytsmen.java.encryption.eratosthenes;

import edu.kytsmen.java.encryption.eratosthenes.core.PrimeNumber;
import edu.kytsmen.java.encryption.eratosthenes.utils.InteractionUtils;

public class Main {
    public static void main(String[] args) {
        InteractionUtils.provideUserInterface(PrimeNumber::calculateWithSieveOfEratosthenes);
//        int n = 33;
//        for (int i : PrimeNumber.calculateWithSieveOfEratosthenes(n)) {
//            System.out.println(i);
//        }
    }
}
