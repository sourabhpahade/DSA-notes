package Array;

public class RearrangeArray {
    /*
     * We have given an array of size n,
     * in which a[i] belongs to [0,n-1]
     * we have rearrange array i.e a[i] = a[a[i]];
     * 
     * Ex : {4,0,2,1,3} => {3,4,2,0,1}
     */

    /*
     * Naive Approach : creating an aux. array of size n
     * storing elements there
     */

    /*
     * Better Approach : O(1) extra space => we use the fact that a[i] is in range
     * of [0,n-1]
     * we use euclid's division theorem i.e modified a[i] = new a[i] * n + old a[i]
     * then we run another loop to change modified value to req value by
     * modified a[i] / n --> gives a[a[i]] new value
     * modifief a[i] % n --> gives a[i] old value
     */

    static void rearrange(int[] a) {

        int n = a.length;

        for (int i = 0; i < n; i++) {

            // a[a[i]]%n => new value
            a[i] = ((a[a[i]] % n) * n) + a[i];
        }

        for (int i = 0; i < n; i++) {
            a[i] = a[i] / n;
        }

    }

    /*
     * In this we have given sorted array and we have to arrange the array i.e
     * a[] = {1,2,3,4,5,6} => {6,1,5,2,4,3}
     */
    static void rearrange2(long arr[], int n) {

        // index of max element
        int j = n - 1;

        // divisor
        long k = arr[n - 1] + 1l;

        for (int i = 0; i < n; i++) {

            // if i is even we store max elements
            if (i % 2 == 0) {
                arr[i] = (arr[j] % k) * k + arr[i];
                j--;
            }
            // we store min elements in odd places
            else {
                arr[i] = (arr[i / 2] % k) * k + arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / k;
        }

    }

    static void print(int[] a) {

        for (int x : a) {
            System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {

        int[] a = { 4, 0, 2, 1, 3 };
        rearrange(a);
        print(a);
    }
}
