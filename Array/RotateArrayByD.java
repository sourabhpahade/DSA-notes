package Array;

/*
 * We have given an array , and we have to rotate it either left or right by d
 * EX -> {1,2,3,4,5} d = 2 (left) => {3,4,5,1,2}
 */

public class RotateArrayByD {

    /*
     * Approach : O(n) time, Using aux array of size d to store the rotation element
     */

    static int[] leftRotate(int[] a, int d) {

        int n = a.length;

        d = d % n;

        int[] temp = new int[d];

        // filling temp
        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }

        // shifting elements in a i.e => a[i-d] = a[i]
        for (int i = d; i < n; i++) {
            a[i - d] = a[i];
        }

        // filling temp elements at rotatated places
        for (int i = 0; i < d; i++) {
            a[n - d + i] = temp[i];
        }

        return a;

    }

    /*
     * Using Reversal Theorem : takes O(n) time, and works in-place
     */

    static void reverse(int[] a, int start, int end) {

        while (start < end) {

            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;

            start++;
            end--;
        }
    }

    static void left(int[] a, int d) {
        int n = a.length;
        d = d % n;

        reverse(a, 0, d - 1);
        reverse(a, d, n - 1);
        reverse(a, 0, n - 1);

    }

    // EX -> {1,2,3,4,5} d = 2 => {4,5,1,2,3}
    static void right(int[] a, int d) {
        int n = a.length;
        d = d % n;

        reverse(a, 0, n - 1); // => {5,4,3,2,1}
        reverse(a, 0, d - 1); // => {4,5,3,2,1}
        reverse(a, d, n - 1); // => {4,5,1,2,3}

    }

    public static void main(String[] args) {

    }
}
