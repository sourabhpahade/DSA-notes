package String;

/*
 * In this we have given a string and we have to find longest proper prefix and suffix
 * For ex :- "abc" , -> proper prefixes are "", "a", "ab" and suffixes are "", "c", "bc", "abc".
 * longest proper prefix length will be n-1.
 */
public class LPS {

    /*
     * Naive Solution: O(n cube) time, O(n) space for lps array
     * 
     * 1. we take suffix len = n-1 -> 1,
     * 2. we take prefix till i = 0 -> len-1.
     * 3. we check if prefix == suffix by checking if (s[i] == s[n-len+i])
     * 4. if we above is false we return 0, else we return len.
     * 5. To fill lpsArray we run a loop from 0 -> n-1, and lps[i] = check(s,i+1).
     */

    static int check(String s, int n) {

        for (int len = n - 1; len > 0; len--) {

            boolean flag = true;

            for (int i = 0; i < len; i++) {

                if (s.charAt(i) != s.charAt(n - len + 1)) {

                    flag = false;
                    break;
                }

            }
            if (flag) {
                return len;
            }
        }
        return 0;
    }

    static int[] lps1(String s) {

        int[] lps = new int[s.length()];

        for (int i = 0; i < lps.length; i++) {
            lps[i] = check(s, i + 1);
        }

        return lps;
    }

    /*
     * O(n sq) time, O(n) space but extra space is also there to store prefixes and
     * suffixes which will create large overhead of space in heap.
     */
    static int[] lps2(String str) {

        int n = str.length();
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {

            int s = 0;
            int e = i;
            int temp = 0;
            String prefix = "";
            String suffix = "";

            while (s < i) {

                prefix += str.charAt(s);
                suffix = str.charAt(e) + suffix;

                if (prefix.equals(suffix)) {
                    temp = s + 1;
                }
                s++;
                e--;
            }

            lps[i] = temp;
        }

        for (int x : lps) {
            System.out.print(x + " ");
        }

        return lps;
    }

    /*
     * O(n) time, space.
     * 
     * we use the previously calculated values of lps array for the computation
     * of next lps values
     * 
     * 1. len = lps[i-1], if (str[i] == str[len]) => len++,i++, lps[i]= len;
     * 2. if not equal, if(len == 0) lps[i] = 0,;
     * 3. if(len > 0) len = lps[len-1];
     */
    static int[] lps3(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;

            } else {

                if (len == 0) {

                    lps[i] = 0;
                    i++;

                } else {

                    len = lps[len - 1];

                }
            }
        }

        for (int x : lps) {
            System.out.print(x + " ");
        }

        return lps;
    }

    public static void main(String[] args) {

        lps3("acccbaaacccbaac");
    }
}
