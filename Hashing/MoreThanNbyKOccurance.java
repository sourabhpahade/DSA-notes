package Hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * MoreThanNbyKOccurance : In this we have to print elements which occured more
 * than n/k times.
 */
public class MoreThanNbyKOccurance {

    /*
     * Approch 1: O(nlogn)+theta(n) => first we sort the array, then we traverse and
     * count the occurance
     */

    /*
     * Better Approach: O(n) time space => we use hashmap to store elements and
     * their freq as values. we traverse again to check if there is any element
     * having freq > n/k
     */
    static void solution(int[] a, int k) {

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            if (m.containsKey(a[i])) {
                m.put(a[i], m.getOrDefault(a[i], 0) + 1);
            } else {
                m.put(a[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> x : m.entrySet()) {

            if (x.getValue() > a.length / k) {
                System.out.println(x.getKey());
            }
        }

    }

    public static void main(String[] args) {

        int[] a = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
        solution(a, 4);
    }
}