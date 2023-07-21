package Hashing;

import java.util.HashSet;

public class SubArraywith0Sum {

    /*
     * Naive Approach is checking each subarray , time => O(n sq.)\
     *
     */

    // Better Approach

    /*
     * Better Approach: Here We use Hashing and Pregix Sum together
     * 
     * 1. While traversing array we calculate prefix sum
     * 2. we check if prefixSum == 0
     * 3. we check if hashSet contains prefix sum , if yes then we return true ,
     * 4. we add prefixSum in hashSet
     */

    static boolean subArrayZeroSum(int[] a) {

        HashSet<Integer> h = new HashSet<>();

        int prefixSum = 0;

        for (int x : a) {

            prefixSum += x;

            if (prefixSum == 0)
                return true;

            if (h.contains(prefixSum))
                return true;

            h.add(prefixSum);
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
