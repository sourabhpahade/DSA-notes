package Hashing;

/*
 * Given two binary array of same size, we have to find longest common subarray.
 */
public class LongestCommonSubarrayGivenSum {

    /*
     * Approach 1 : O(n sq) => Simply compare the sum of both arrys for each
     * subarray
     */

    /*
     * Approach 2 : O(n) time, space => using hashmap and prefix sum.
     * Here we just need to merge to array by doing b[i]-a[i] and find longest
     * subarray with zero sum in merged array
     */

    static int solution(int[] a, int[] b) {

        int[] temp = new int[a.length];

        for (int i = 0; i < temp.length; i++) {

            temp[i] = a[i] - b[i];

        }

        int res = LongestSubarrayGivenSum.solution(temp, 0);

        return res;

    }

    public static void main(String[] args) {

        int[] a = { 0, 1, 0 };
        int[] b = { 1, 0, 0 };

        System.out.println(solution(a, b));

    }
}
