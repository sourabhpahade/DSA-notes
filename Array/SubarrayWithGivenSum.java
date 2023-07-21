
package Array;

import java.util.ArrayList;

/**
 * SubarrayWithGivenSum : Given a array of +ve integer we have to find subarray
 * with given sum
 */
public class SubarrayWithGivenSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        int curr = 0;
        int s = 0;

        for (int e = 0; e < n; e++) {

            // prefix sum
            curr += arr[e];

            // sliding the window
            while (curr > sum) {
                curr -= arr[s];
                s++;
            }

            if (curr == sum && sum > 0) {
                res.add(s + 1);
                res.add(e + 1);
                return res;
            }
        }

        res.add(-1);
        return res;
    }
}