
package Array;

/**
 * MinimumGroupsToFlip
 */
public class MinimumGroupsToFlip {

	// Q. Minimum groups to flip to make binary array same.

	// Logic: If a[0]==a[n-1] then our group which takes min. flips is other than
	// a[0].
	// Else we can take any group because both are present in same quantity.

	// Ex: [1,1,0,0,0,1,1,1,0,0,1] => a[0]==a[n-1]==1 means 0's group will have min.
	// flips

	static void printGroups(int arr[], int n) {

		for (int i = 1; i < n; i++) {

			if (arr[i] != arr[i - 1]) {

				if (arr[i] != arr[0]) {
					System.out.print("From " + i + " to ");
				} else {
					System.out.println(i - 1);
				}
			}
		}

		if (arr[n - 1] != arr[0])
			System.out.println(n - 1);
	}

}
