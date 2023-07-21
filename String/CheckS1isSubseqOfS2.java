package String;

/*
 * We have given two strings s1 and s2 we have to find if s2 is subsequence of s1
 */

public class CheckS1isSubseqOfS2 {

    /*
     * Approach 1: O(n*m) => checking each char of s2 present in s1 in sequencial
     * order.
     */

    static boolean check(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int idx = -1;
        int count = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (s2.charAt(i) == s1.charAt(j) && idx < j) {
                    idx = j;
                    count++;
                    break;
                }
            }

        }

        if (count == m)
            return true;

        return false;
    }

    /*
     * Approch 2: O(n) => we can maintain i,j pointer i to traverse s1 and j to
     * traverse s2 , we increment j if s1[i] == s2[j], we also maintain counter, if
     * count == s2 length, return true else false
     */

    static boolean check2(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int i = 0;
        int j = 0;

        while (i < n && j < m) {

            if (s2.charAt(j) == s1.charAt(i)) {
                j++;
            }
            i++;
        }

        if (j == m) {
            return true;
        }

        return false;
    }

    // recursive code for check2
    static boolean recursiveCheck2(String s1, String s2, int i, int j) {

        if (s1.length() < s2.length())
            return false;

        if (j == s2.length())
            return true;

        if (i == s1.length())
            return false;

        if (s1.charAt(i) == s2.charAt(j)) {
            return recursiveCheck2(s1, s2, i + 1, j + 1);
        }
        return recursiveCheck2(s1, s2, i + 1, j);
    }

    public static void main(String[] args) {

        String s1 = "abcd";
        String s2 = "d";

        System.out.println(recursiveCheck2(s1, s2, 0, 0));

    }
}
