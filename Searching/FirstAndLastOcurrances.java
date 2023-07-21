package Searching;

public class FirstAndLastOcurrances {

    /*
     * Finding 1st occurance in sorted array in log(n) time
     */

    static int firstOccurance(int[] a, int x, int low, int high) {

        while (low <= high) {

            int mid = (low + high) / 2;

            if (x > a[mid]) {

                low = mid + 1;

            } else if (x < a[mid]) {

                high = mid - 1;

            } else {

                if (mid == 0 || a[mid] != a[mid - 1]) {

                    return mid;

                } else {

                    high = mid - 1;
                }
            }

        }

        return -1;
    }

    /*
     * Finding last ocuurance in sorted array
     */
    static int lastOccurance(int[] a, int x, int low, int high) {

        while (low <= high) {

            int mid = (low + high) / 2;

            if (x > a[mid]) {

                low = mid + 1;

            } else if (x < a[mid]) {

                high = mid - 1;

            } else {

                if (mid == a.length - 1 || a[mid] != a[mid + 1]) {

                    return mid;

                } else {

                    low = mid + 1;

                }
            }

        }

        return -1;
    }

    /*
     * count occurances
     */

    static int countOccur(int a[], int x) {

        int res = lastOccurance(a, x, 0, a.length - 1) - firstOccurance(a, x, 0, a.length) + 1;

        return res;
    }

    public static void main(String[] args) {

        int[] a = { 1, 2, 3, 4, 4, 4, 5, 6, 7 };

        System.out.println(firstOccurance(a, 4, 0, a.length - 1));
        System.out.println(lastOccurance(a, 4, 0, a.length - 1));
        System.out.println(countOccur(a, 4));

    }
}
