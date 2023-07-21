package String;

/*
 *  WE have given a String i.e "abbcc" we need to return index of left most element which is repeated => 1 in this case
 */
public class LeftMostRepeating {

    /*
     * Naive Approach: O(n sq.) => check each element from left if find break the
     * loops the return i.
     */

    /*
     * Better Appraoch: O(n) => two traversal solution, using freq array
     */

    static int leftMostrep(String s) {

        // creating freq array of size 26 for alphabets
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {

            freq[s.charAt(i) - 'a']++;

        }

        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] > 1) {
                return i;
            }

        }

        return -1;

    }

    /*
     * One Traversal solution => using visited array, we traverse string from right
     * side.
     */

    static int sol2(String s) {

        // creating visited array initially it is false by default
        boolean[] visited = new boolean[256];

        int res = -1;

        // trversing string from right side to find the ans
        for (int i = s.length() - 1; i >= 0; i--) {

            if (visited[s.charAt(i)]) {
                res = i;
            }
            visited[s.charAt(i)] = true;
        }

        return res;
    }

    public static void main(String[] args) {

        String s = "abcd";

        System.out.println(sol2(s));
    }
}
