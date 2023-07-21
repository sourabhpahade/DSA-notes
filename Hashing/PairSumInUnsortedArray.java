package Hashing;

import java.util.*;

public class PairSumInUnsortedArray {

    /*
     * We need to find in unsorted array if there exist any pair == given sum
     */

    /*
     * Approach 1 : O(n square) check every pair
     */

    // Approach 2 : O(n) time and space using hashSet

    static boolean isPairExist(int[] a, int sum) {

        HashSet<Integer> y = new HashSet<>();

        for (int i = 0; i < a.length; i++) {

            int temp = sum - a[i];

            // we are checking first then adding y
            if (y.contains(temp)) {
                return true;
            }

            y.add(a[i]);

        }

        return false;

    }

    public static void main(String[] args) {

        int[] a = { 2, 1, 6, 3 };

        System.out.println(isPairExist(a, 6));

    }
}
