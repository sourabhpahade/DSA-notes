package Sorting;

public class MergeSort {

    static void mergeSort(int[] arr, int l, int r) {

        // if there is array of length > 1
        if (l < r) {

            int mid = l + (r - l) / 2; // this expression will prevent overflow

            // calling mergSort for left half
            mergeSort(arr, l, mid);

            // calling mergeSort for right half
            mergeSort(arr, mid + 1, r);

            // merging the sorted arrays in each call bottom-up
            merge(arr, l, mid, r);

        }

    }

    // merge function to merge two sorted arrays
    static void merge(int[] arr, int l, int m, int r) {

        // dividing two arrays in two sorted parts
        // getting size of the arrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // making and filling left sorted array
        int[] left = new int[n1];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }

        // making and filling right sorted array
        int[] right = new int[n2];

        for (int i = 0; i < n2; i++) {
            right[i] = arr[m + i + 1];
        }

        // merging left and right in sorted order
        int i = 0; // to traverse left
        int j = 0; // to traverse right
        int k = l; // to traverse given arr

        while (i < n1 && j < n2) {

            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
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

    }
}
