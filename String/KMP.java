package String;

/*
 *  It is Pattern Seaching algorithm, we have given a text and a pattern we have to find the index of patterns in the given text 
 */

public class KMP {

    /*
     * This algorithm helps to find the ocuurances of patterns in text in O(n) time.
     * For this we use lps array of pattern to slide the pattern on text, but lps
     * array reduces many comparison compared to naive approach
     * 
     * KMP uses the basic idea of naive pattern searching with distinct character
     * pattern
     * 
     * 1. we first pre-process the lps array for pattern
     * 
     * 2. take i=0,j=0 to traverse text and pattern
     * 
     * 3. if(txt[i] == pat[j]) i++; j++;
     * 
     * 4. if(j == m) print(i-j) ; i++;
     * ( j = lps[j-1] => this will give us the last char of pattern and we just need
     * to check next txt[i] to pat[j] as lps ensures that if it is true/matching
     * then prev
     * chars are also true/matching)
     * 
     * 5. if no matched then we check if j == 0 if yes we simply i++ => as first
     * char is not matched so no need to process the whole pat.
     * else if (j > 0) we j = lps[j-1] => this way we are checking the prev chars by
     * sliding the pat ahead on text.
     * 
     */

    static void patternSearch(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        int[] lps = LPS.lps3(pat);

        int i = 0, j = 0;

        while (i < n) {

            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {

                System.out.println(i - j);
                i++;
                // getting last char of pat and sliding pat by +1;
                j = lps[j - 1];

            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {

                if (j == 0) {
                    // first char of pat is not matched
                    i++;
                } else {
                    // sliding pattern ahead
                    j = lps[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
