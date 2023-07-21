package String;

/**
 * NaivePatternSearching
 */
public class NaivePatternSearching {

    /*
     * O((n-m+1)* m) time => we slide the pattern in the string for each index
     */
    static void patternSearch(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        int notFound = -1;

        for (int i = 0; i <= n - m; i++) {

            int j;
            for (j = 0; j < m; j++) {

                if (pat.charAt(j) != txt.charAt(i + j)) {
                    break;
                }
            }

            if (j == m) {
                notFound = 0;
                System.out.println(i);
            }
        }

        if (notFound == -1) {
            System.out.println(notFound);
        }

    }

    /*
     * Naive pattern Search when character in pattern is distinct takes O(n) time
     */

    static void distPatternSearch(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        int j = 0;
        for (int i = 0; i < n; i++) {

            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                j = 0;
                if (txt.charAt(i) == pat.charAt(j)) {
                    j++;
                }
            }

            if (j == m) {
                System.out.println(i - m + 1);
                j = 0;
            }
        }

    }

    public static void main(String[] args) {

        distPatternSearch("abceabcdabceabcd", "abcd");
    }

}