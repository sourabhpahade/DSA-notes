package String;

/*
 * This algorithm is used to search pattern in given text
 */
public class RabinKarp {
    /*
     * Robin-karp algo is similar to naive approach but instead of checking each
     * character of current window with each char. of pattern.
     * We compute hash value of each window in text of length m (len. of pattern)
     * and compute hash value of pattern itself. if these values match then we check
     * each char.
     */

    // d is base which is the types of characters present in text
    static final int d = 256;

    /*
     * txt -> text string
     * pat -> pattern String
     * q -> large prime number used to prevent overflow of int value and
     * If the modulo value(q) is large enough then the spurious hits occur
     * infrequently enough that the cost of extra checking is low.
     */
    static void patternSearch(String txt, String pat, int q) {

        // lengths
        int n = txt.length();
        int m = pat.length();

        // STEP => 1
        // computing d^m-1
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // STEP => 2
        // pre-computing hash value of 1st window of text and hash value of pattern
        // t -> hash value of text window
        // p -> hash value of pattern
        // for this we use horner's rule
        // i.e t = txt[0]*d^m-1 + txt[1]*d^m-2 +.....+txt[m-1]*d^0

        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (p * d + pat.charAt(i)) % q;
            t = (t * d + txt.charAt(i)) % q;
        }

        // STEP => 3
        // checking pattern match for all windows in text

        // running loop from 0 -> n-m+1
        for (int i = 0; i <= n - m; i++) {

            // hash value matched
            if (t == p) {

                // checking sporious/false hits
                boolean flag = true;
                for (int j = 0; j < m; j++) {

                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                // if there is no false hit means match found
                if (flag) {
                    System.out.print(i + " ");
                }
            }
            // computing hash value of next window
            // i < m-n ensures that we don't execedes the last window
            if (i < n - m) {

                // rolling hash function to compute next window's hash
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;

                // if t becomes -ve we add q to it to maintain =ve value i.e to avoid faulty
                // comparision
                if (t < 0) {
                    t = t + q;
                }
            }
        }

    }

    public static void main(String[] args) {

        String txt = "aabbccddeeddff";
        String pat = "ddee";

        patternSearch(txt, pat, 101);
    }
}
