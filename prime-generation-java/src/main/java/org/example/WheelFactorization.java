package org.example;

import java.util.ArrayList;

//wheel factorization is a method for generating a sequence of natural numbers by repeated additions,
//as determined by a number of the first few primes, so that the generated numbers are coprime with these primes, by construction.
public class WheelFactorization {
    public static boolean div(int n, int k) {
        return n%k == 0;
    }

    //returns smallest divisor of n
    public static int smallestDivisor(int n, int[] inc) {//inc = {4,2,4,2,4,6,2,6}
        if (div(n, 2)) return 2;
        if (div(n, 3)) return 3;
        if (div(n, 5)) return 5;
        int k = 7, i = 0;
        while(k*k <= n) {
            if (div(n, k)) return k;
            k += inc[i];
            if (i<7)
                i++;
            else
                i = 0;
        }
        return n;
    }

    public static ArrayList<Integer> primeFactorization(int n, int[] inc) {
        ArrayList<Integer> factors = new ArrayList<>();
        while((div(n,2))) {
            factors.add(2);
            n /= 2;
        }
        while((div(n,3))) {
            factors.add(3);
            n /= 3;
        }
        while((div(n,5))) {
            factors.add(5);
            n /= 5;
        }
        int k = 7, i = 0;
        while(k*k <= n) {
            if (div(n, k)) {
                factors.add(k);
                n /= k;
            } else {
                k += inc[i];
                if (i<7)
                    i++;
                else
                    i = 0;
            }
        }
        if (n>1)
            factors.add(n);
        return factors;
    }
}
