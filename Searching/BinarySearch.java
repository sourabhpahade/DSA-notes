package Searching;

/*
 * In binary Search array should be sorted.
 * In this what we do is we take mid = (low+high)/2
 * if(a[mid] == x) return mid;
 * if(x>a[mid]) low = mid+1 , x will be on right side
 * else high = mid-1, x will be on left side
 */

public class BinarySearch {

    static int binarySearch(int[] a, int x, int low, int high) {

        while (low <= high) {

            int mid = (low + high) / 2;

            if (a[mid] == x) {

                return mid;

            }

            if (x > a[mid]) {

                low = mid + 1;

            } else {

                high = mid - 1;
            }

        }

        return -1;
    }

    static int recursiveBSearch(int[] a, int x, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (a[mid] == x) {
            return mid;
        }

        if (x > a[mid]) {
            return recursiveBSearch(a, x, mid + 1, high);
        }
        return recursiveBSearch(a, x, low, mid - 1);

    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 5, 6, 7 };

        System.out.println(recursiveBSearch(a, 1, 0, a.length - 1));
    }
}
