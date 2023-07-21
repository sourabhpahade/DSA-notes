package Searching;

/*
 * We have to find floor of square root of the given number
 */
public class SquareRoot {

    /*
     * Naive solution: O(Square root of n)
     */

    static int sqRoot(int n) {

        int res = 1;

        while (res * res <= n) {
            res++;
        }

        return res - 1;
    }

    /*
     * optimized solution: O(log n) using binary search
     */

    static int sqRoot1(int n) {

        int low = 1;
        int high = n;
        int res = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int sq = mid * mid;

            if (sq == n) {

                return mid;

            }

            if (sq > n) {

                high = mid - 1;

            } else {

                low = mid + 1;
                res = mid;
            }

        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(sqRoot1(14));
    }
}
