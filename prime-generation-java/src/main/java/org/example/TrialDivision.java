package org.example;


import java.util.ArrayList;
import java.util.HashSet;

//trial division is an integer factorization algorithm that can also be used to generate prime numbers
//methods here return unique prime factors
public class TrialDivision {
    public static ArrayList<Integer> trialDivision1(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        HashSet<Integer> primeSet = new HashSet<>();
        int f = 2;
        while (n > 1) {
            if (n % f == 0) {
                if (!primeSet.contains(f)) {
                    primes.add(f);
                }
                n /= f;
            } else {
                f++;
            }
        }
        return primes;
    }

    public static ArrayList<Integer> trialDivision2(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        HashSet<Integer> primeSet = new HashSet<>();
        while (n % 2 == 0) {
            if (!primeSet.contains(2)) {
                primes.add(2);
            }
            n /= 2;
        }
        int f = 3;
        while (f*f <= n) {
            if (n % f == 0) {
                if (!primeSet.contains(f)) {
                    primes.add(f);
                }
                n /= f;
            } else {
                f += 2;
            }
        }
        if(n != 1) primes.add(n);
        return primes;
    }
}
