package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfSundaram {//S.P. Sundaram, 1934
    public static List<Integer> sundaram1(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        //int[] result = new int[2*n+2];
        for(int d=1; d<n+1; d++)
            result.add(d);
        int i = 0, j = 0;
        int m = i+j+2*i*j;
        while(m <= n) {
            m = i+j+2*i*j;
            result.remove(m);
        }
        return result;
    }

    public static List<Integer> sundaram2(int n) {
        int k = (n-2)/2;
        boolean[] integers_list = new boolean[k+1];
        Arrays.fill(integers_list, true);
        for(int i=1; i<k+1; i++) {

        }
    }
}
