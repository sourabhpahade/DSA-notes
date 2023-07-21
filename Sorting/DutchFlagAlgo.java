package Sorting;

public class DutchFlagAlgo {

    /*
     * This algorithm helps us to sort three type of elemnts in theta(n) time.
     * 
     * There are Three Types of problem
     * 
     * 1. Sorting 0-1-2
     * 2. Three way partitioning
     * 3. sort around a pivot
     */

    public static void segragate012(int a[], int N) {
        // Your Code Here

        int i = 0;
        int m = 0;
        int j = N - 1;

        while (m <= j) {

            if (a[i] == 0) {
                i++;
                m++;
                continue;
            }

            if (a[j] == 2) {
                j--;
                continue;
            }

            if (a[m] == 1) {
                m++;
                continue;
            }

            if (a[m] == 0) {
                swap(a, i, m);
                i++;
            } else if (a[m] == 2) {
                swap(a, j, m);
                j--;
            }
        }
    }

    public void threeWayPartition(int arr[], int a, int b) {
        // code here
        int l = 0;
        int m = 0;
        int h = arr.length - 1;

        while (m <= h) {

            if (arr[m] < a) {
                swap(arr, l, m);
                l++;
                m++;
            } else if (arr[m] > b) {
                swap(arr, m, h);
                h--;
            } else {
                m++;
            }
        }
    }

    static void swap(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
