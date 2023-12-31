
package Array;

/**
 * MaxCircularSubarraySum
 */
public class MaxCircularSubarraySum {

    // Q. Max Circular Subarray Sum.
    // -----------------------------------

    // Logic: 1. Find the normal max Subarray sum.
    // 2. Find Circular max Subarray sum by (arrSum - minSubarraySum)
    // 3. return max(normal,circular).

    static int circularSubarraySum(int a[], int n) {

        // Your code here
        int normalMax = kadane(a, n);

        if (normalMax < 0)
            return normalMax;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
            a[i] = -a[i];
        }

        int circularMax = sum + kadane(a, n);

        return Math.max(normalMax, circularMax);
    }

    static int kadane(int a[], int n) {

        int res = a[0];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
            res = Math.max(res, sum);

            if (sum < 0)
                sum = 0;
        }

        return res;
    }
}
