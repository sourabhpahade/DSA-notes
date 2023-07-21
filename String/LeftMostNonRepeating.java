package String;

import java.util.Arrays;

/*
 * In this we have given a string s, we have to find left most non repeating element
 */
public class LeftMostNonRepeating {

    /*
     * Naive Approach: O(n sq.) => check each element using two loops
     * 
     * Better solution: O(n) => two traversal, using freq array and inc freq., we
     * have to traverse string twice. This solution not works for incoming stream of
     * chars in real time.
     */

    /*
     * One traversal solution => using aux array to store firdt index of non
     * repeating chars, but we only traverse string once,
     * 2nd traveral will be of freq array, advantage of this solution it will work
     * for streams of chars coming in real time
     */

    static char solution(String s) {

        // aux array to store first indexes
        int[] fIndex = new int[256];
        Arrays.fill(fIndex, -1);

        int res = 256;

        // traversing string
        for (int i = 0; i < s.length(); i++) {

            if (fIndex[s.charAt(i)] == -1) {
                fIndex[s.charAt(i)] = i;
            } else {
                fIndex[s.charAt(i)] = -2;
            }
        }

        for (int i = 0; i < 256; i++) {

            if (fIndex[i] >= 0) {
                res = Math.min(res, fIndex[i]);
                // System.out.println(res);
            }

        }

        return res == 256 ? '$' : s.charAt(res);

    }

    public static void main(String[] args) {

        String s = "abcd";
        System.out.println(solution(s));
    }
}
