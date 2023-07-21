package Hashing;

public class LongestSubarrayWithEqual0s1s {

    // Naive Solution
    static int solution(int[] a) {

        int res = 0;

        for (int i = 0; i < a.length; i++) {

            int one = 0;
            int zero = 0;

            for (int j = i; j < a.length; j++) {

                if (a[j] == 1) {
                    one++;
                }

                if (a[j] == 0) {
                    zero++;
                }

                if (one == zero) {
                    System.out.println(i + " " + j);
                    res = Math.max(res, j - i + 1);
                }

            }
        }

        return res;
    }

    /*
     * Better Solution: Linear time, spce
     * 
     * 1. switch all 0s with -1.
     * 2. now find longest subarray with sum
     * 
     */

    static int solution2(int[] a) {

        for (int i = 0; i < a.length; i++) {

            if (a[i] == 0) {
                a[i] = -1;
            }
        }

        int res = LongestSubarrayGivenSum.solution(a, 0);

        return res;

    }

    public static void main(String[] args) {

        int[] a = { 1, 0, 1, 1, 1, 0, 0 };

        System.out.println(solution2(a));

    }
}
