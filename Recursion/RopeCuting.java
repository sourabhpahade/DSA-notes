
package Recursion;

/**
 * RopeCuting
 */
public class RopeCuting {

    // Q) cut the rope of length n in max possible way.
    // => time complexity O(n)

    public static int ropeCutting(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int res = maxThree(ropeCutting(n - a, a, b, c),
                ropeCutting(n - b, a, b, c),
                ropeCutting(n - c, a, b, c));

        if (res < 0) {
            return -1;
        }
        return res + 1;

    }

    public static int maxThree(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }
}
