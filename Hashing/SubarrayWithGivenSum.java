package Hashing;

import java.util.HashMap;

public class SubarrayWithGivenSum {

    /*
     * In this we have to find the no. subarrays with given Sum.
     * 
     * Approach 1: O(n sq.) => Check every Subaarays with given sum using two loops
     * Approach 2: O(n) => Using Sliding Window if array contain only +ve no.
     * 
     * Approach 3: O(n) time,space => Using Hashing and prefix Sum.
     */

    static int subarraysWithGivenSum(int[] a, int k) {

        // initializing count as 0 as if no subarrays found we return 0
        int res = 0;

        // initlizing PrefixSum var and Empty HashMap to store prefixSums and the freq.
        // of its occurance
        // Prefix sum basically gives us the subarray sum till each index

        int preSum = 0;
        HashMap<Integer, Integer> m = new HashMap<>();

        // our main logic
        // we run a loop from 0 --> n-1

        for (int i = 0; i < a.length; i++) {

            // increment preSum and checking if it == sum
            preSum += a[i];

            // Checking if there exist any subarray with given Sum
            if (preSum == k) {
                res++;
            }

            // Here if prefix > k, then if there exist preSum-k value in h
            // we know we got an SubarrayWith given Sum.
            if (m.containsKey(preSum - k)) {

                res += m.get(preSum - k);

            }

            // inc freq. of if subarray with sum presum already exist
            if (m.containsKey(preSum)) {

                int temp = m.get(preSum) + 1;
                m.put(preSum, temp);

            } else {

                m.put(preSum, 1);
            }

        }

        return res;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 4, 20, 3, 10, 5 };

        System.out.println(subarraysWithGivenSum(arr, 33));

    }
}
