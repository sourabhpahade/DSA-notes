
package Array;

import java.util.ArrayList;

/**
 * TripletSumToX
 */
public class TripletSumToX {

	// You have been given a non-decreasing integer ArrayList(arr) and a number X.
	// Find and return the number of distinct triplets in the ArrayList which sum to
	// X.

	// Given ArrayList is sorted and can contain duplicate elements.

	// logic:
	// 1. Sort the array.
	// 2. use two pointer to find the sum
	// 3. skip the duplicate occurences of i,j,k.

	// time complexity is n^2;

	// => brute-force will use 3 loops to find triplets

	public static int triplets(ArrayList<Integer> arr, int X) {
		// your code here
		int res = 0;
		int n = arr.size();
		for (int i = 0; i < arr.size() - 2; i++) {

			// Skipping duplicate i
			if (i == 0 || arr.get(i) > arr.get(i - 1)) {

				// making two pointers
				int j = i + 1;
				int k = n - 1;

				while (j < k) {

					// skipping duplicate j and k
					if (j > i + 1 && arr.get(j) == arr.get(j - 1)) {
						j++;
						continue;
					}
					if (k < n - 1 && arr.get(k) == arr.get(k + 1)) {
						k--;
						continue;
					}

					// checking sum of triplets if sum<X we j++
					if (arr.get(i) + arr.get(j) + arr.get(k) < X) {
						j++;
					}

					// checking sum of triplets if sum>X we k--
					else if (arr.get(i) + arr.get(j) + arr.get(k) > X) {
						k--;
					}

					// checking sum of triplets if sum==X we j++,k--
					else if (arr.get(i) + arr.get(j) + arr.get(k) == X) {
						j++;
						k--;
						res++;
					}
				}
			}
		}
		return res;
	}
}
