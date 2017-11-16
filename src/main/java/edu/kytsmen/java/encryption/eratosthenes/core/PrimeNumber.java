package edu.kytsmen.java.encryption.eratosthenes.core;

import edu.kytsmen.java.encryption.eratosthenes.dto.Result;

public class PrimeNumber {
    public static Result calculateWithSieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i < n; ++i) {
            prime[i] = true;
        }

        int primeCounter = n - 2;
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
        int[] primes = new int[primeCounter];
        int counter = 0;
        for (int i = 2; i <= n; ++i) {
            if (prime[i]) {
                primes[counter] = i;
                ++counter;
            }
        }
        return new Result(primes);
    }
}
