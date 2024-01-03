package org.example;


import java.util.ArrayList;

//prime number: a natural number greater than 1 that is not a product of two smaller natural numbers
public class SieveOfEratosthenes {

    //@Benchmark
    public static ArrayList<Integer> trialDivision(int n){//n >= 3
        ArrayList<Integer> primes = new ArrayList<>();
        primes.add(2);
        int num = 3;
        while(num <= n){
            boolean isPrime = true;
            for (Integer prime : primes){//improve this, only go up to sqrt(num)
                if (num % prime == 0){
                    isPrime = false;
                }
            }
            if (isPrime)
                primes.add(num);
            num++;
        }
        System.out.println("\nprinting trial division primes: \n");
        for (Integer prime: primes)
            System.out.print(prime + " ");
        return primes;
    }

    //generates all prime numbers up to n
    //O(nloglogn)
    //@Benchmark
    public static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> primes = new ArrayList<>();
        int[] integers = new int[n+1];//indexes 2,3,4,...,n represent integers 2 through n; values are 0 by default
        for(int i=2; i<Math.sqrt(n); i++){
            if (integers[i]==0){//i is a prime
                int k = 0;
                int num = i*i + k*i;
                while(num <= n){
                    integers[num] = 1;
                    k++;
                    num = i*i + k*i;
                }
            }
        }
        //indexes with value 0 are primes
        System.out.println("printing primes <= " + n + "\n");
        for (int i = 2; i<integers.length; i++){
            if (integers[i]==0){
                primes.add(i);
                System.out.print(i + " ");
            }
        }
        return primes;
    }

    public static ArrayList<Integer> segmentedSieve(int n, int delta){
        if (delta > Math.sqrt(n)) throw new IllegalArgumentException("delta greater than sqrt(n)");
       //int[] myInts = new int[delta+1];
        ArrayList<Integer> primes1 = sieveOfEratosthenes(delta+1);
        int noSegments = n / delta;
        for (int j=2; j<noSegments; j++){
            int[] integers = new int[delta];

        }

        ArrayList<Integer> primes = new ArrayList<>();
        int[] integers = new int[n+1];//indexes 2,3,4,...,n represent integers 2 through n; values are 0 by default
        for(int i=2; i<Math.sqrt(n); i++){
            if (integers[i]==0){//i is a prime
                int k = 0;
                int num = i*i + k*i;
                while(num <= n){
                    integers[num] = 1;
                    k++;
                    num = i*i + k*i;
                }
            }
        }
        //indexes with value 0 are primes
        System.out.println("printing primes <= " + n + "\n");
        for (int i = 2; i<integers.length; i++){
            if (integers[i]==0){
                primes.add(i);
                System.out.print(i + " ");
            }
        }
        return primes;
    }

    public static void main(String[] args) throws Exception{
        //org.openjdk.jmh.Main.main(args);
        ArrayList<Integer> primes = SieveOfEratosthenes.sieveOfEratosthenes(53);
        ArrayList<Integer> primes2 = trialDivision(53);
    }
}
