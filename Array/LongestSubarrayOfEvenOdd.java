
package Array;

/**
 * LongestSubarrayOfEvenOdd
 */
public class LongestSubarrayOfEvenOdd {

    /*
     * que: You are given an array of size n.Find the maximum possible length of a
     * subarray such that its elements are arranged alternately either as even and
     * odd or odd and even.
     */

    public static int maxEvenOdd(int arr[], int n) {
        // your code here
        int res = 1;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0 || arr[i - 1] % 2 == 0 && arr[i] % 2 != 0) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }

        }

        return res;
    }

}
