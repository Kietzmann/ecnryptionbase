package edu.kytsmen.java.encryption.eratosthenes.core;

public class SieveManager {
    public static int[] sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        int primeCounter = n - 2;
        for (int i = 0; i < n; ++i) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; ++p) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    if (prime[i]) {
                        --primeCounter;
                    }
                    prime[i] = false;
                }
            }
        }
        int primes[] = new int[primeCounter];
        int counter = 0;
        for (int i = 2; i <= n; ++i) {
            if (prime[i]) {
                primes[counter] = i;
                ++counter;
            }
        }
        return primes;
    }
}
