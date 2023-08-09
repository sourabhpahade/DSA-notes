package Hashing;

import java.util.HashMap;

/**
 * LongestSubarrayGivenSum : in this we have to find size of longest subarray
 * with given sum k
 */
public class LongestSubarrayGivenSum {

    /*
     * Approach 1: O(n sq.) => checking each subarray and maintaining a maxLen
     * variable;
     * 
     * Approach 2: O(n) space,time => We use hashmap to store subsum as key and
     * length of this subsum as value, we find subsum till index i
     * using prefix sum technique
     */

    static int solution(int[] a, int k) {

        // count var to store len. of longest subarray
        int res = 0;

        // declaring hashmap and prefix sum
        HashMap<Integer, Integer> m = new HashMap<>();
        int preSum = 0;

        // main logic
        for (int i = 0; i < a.length; i++) {

            // gives subsum till index i
            preSum += a[i];

            // checking presum == k
            if (preSum == k) {
                res = i + 1;
            }

            // this means we have find subarray with sum == k
            if (m.containsKey(preSum - k)) {

                // gives len of subarray having sum == preSum-k
                int len = m.get(preSum - k);
                // System.out.println(len + " " + i);

                // storing len of longest subarray
                res = Math.max(res, i - len);
            }

            if (!m.containsKey(preSum)) {
                m.put(preSum, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = { 5, 7, -12, 17, 15, -9, 6, 19, 12, 1, -5, 2, -15, 14, -7, -11, -16, 13, 0 };

        System.out.println(solution(a, 17));
    }

}