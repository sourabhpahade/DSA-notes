package Array;

public class MaximumIndex {
    // Need to find max j-i, i.e=> a[j]>=a[i] and j>=i.

    static int maxIndexDiff(int A[], int N) {

        // Creating lmin and rmax array of a[]

        int[] lmin = new int[N];
        int[] rmax = new int[N];

        // storing lmin[] with min value left og index i

        lmin[0] = A[0];

        for (int i = 1; i < N; i++) {
            lmin[i] = Math.min(A[i], lmin[i - 1]);
        }

        // storing max value right of the index i;
        rmax[N - 1] = A[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            rmax[i] = Math.max(A[i], rmax[i + 1]);
        }

        int i = 0, j = 0, res = -1;

        // Traversing array both lmin and rmax from start to end
        // to find max diff index.
        while (i < N && j < N) {

            if (lmin[i] <= rmax[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }

        return res;
    }
}
