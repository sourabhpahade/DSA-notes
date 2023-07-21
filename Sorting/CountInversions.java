package Sorting;

public class CountInversions {

    /*
     * we will count the inversions while sorting
     */
    static long countInversion(long[] a, long l, long r) {

        long c = 0;

        if (l < r) {

            long m = l + (r - l) / 2;

            c += countInversion(a, l, m);
            c += countInversion(a, m + 1, r);
            c += mergeAndCount(a, l, m, r);

        }

        return c;
    }

    static long mergeAndCount(long[] arr, long l, long m, long r) {

        // dividing two arrays in two sorted parts
        // getting size of the arrays
        long n1 = m - l + 1;
        long n2 = r - m;

        // making and filling left sorted array
        long[] left = new long[(int) n1];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[(int) l + i];
        }

        // making and filling right sorted array
        long[] right = new long[(int) n2];

        for (int i = 0; i < n2; i++) {
            right[i] = arr[(int) m + i + 1];
        }

        // merging left and right in sorted order
        int i = 0; // to traverse left
        int j = 0; // to traverse right
        int k = (int) l; // to traverse given arr

        long c = 0;
        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];

                // counting inversions
                c += n1 - i;
                j++;
                k++;
            }

        }

        // merging remaining elements
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }

        return c;
    }
}
