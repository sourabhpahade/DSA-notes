package Hashing;

import java.util.HashMap;

/*
 * We have given an array of size n with window k, 
 * we have to find the count of distinct elements present in window
 * No. of windows = n-k+1
 */

public class DistinctElementsInWindow {

    /*
     * Naive solution takes O((n-k)*k*k) time
     */

    /*
     * Better approach : we store distinct element in hashmap with its last
     * occurance index as value, for every value we check if element with i-k index
     * is present, if present we remove it, we always add current element if exist
     * we update it. After this we print size of map.
     */
    static void solution(int[] a, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < k; i++) {
            m.put(a[i], i);
        }

        System.out.print(m.size() + " ");

        for (int i = k; i < a.length; i++) {

            if (m.get(a[i - k]) == i - k) {
                m.remove(a[i - k]);
            }
            m.put(a[i], i);
            System.out.print(m.size() + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 1, 3, 4, 2, 3 };

        solution(a, 4);
    }
}
