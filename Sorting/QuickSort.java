package Sorting;

public class QuickSort {

    static void quickSort(int[] arr, int l, int r) {

        // if there is more than 1 element in array
        if (l < r) {

            int p = hoars(arr, l, r);

            // calling for elements till pivot
            quickSort(arr, l, p);

            // calling for elements right of pivot
            quickSort(arr, p + 1, r);

        }
    }

    // creating partition func -> using Hoare's partition algo
    static int hoars(int[] a, int l, int r) {

        // choosing random pivot to prevent worst case scenerio
        int pivot = (int) (Math.random() * (r - l - 1)) + l + 1;

        // swapping pivot element with a[l]
        swap(a, l, pivot);

        // pivot becomes a[l]
        pivot = a[l];

        // segregating min and max elements
        int i = l - 1;
        int j = r + 1;

        while (true) {

            do {
                i++;
            } while (a[i] < pivot);

            do {
                j--;
            } while (a[j] > pivot);

            if (i >= j) {
                return j;
            }

            swap(a, i, j);
        }

    }

    // creating partition func -> using lomuto's partition algo
    static int lomuto(int[] a, int l, int r) {

        // finding random pivot from (l,r) -> to prevent worst case scenerio
        int pivot = (int) (Math.random() * (r - l - 1)) + l + 1;

        // swapping pivot with a[r]
        swap(a, pivot, r);

        // pivot becomes a[r]
        pivot = a[r];

        // segregating the elements
        int i = -1;

        for (int j = l; j < r - 1; j++) {

            if (a[j] < pivot) {
                i++;
                swap(a, i, j);
            }
        }

        // fixing the pivot in its right place
        swap(a, i + 1, r);

        return i + 1;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
