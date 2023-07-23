
package Array;

/**
 * KadaneAlgorithm
 */
public class KadaneAlgorithm {

	public static int maxSum(int[] a, int n) {

		int sum = 0;
		int res = a[0];

		for (int i = 0; i < n; i++) {

			sum += a[i];
			res = Math.max(res, sum);

			if (sum < 0) {
				sum = 0;
			}
		}

		return res;
	}
}