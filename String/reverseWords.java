package String;

public class reverseWords {

    /*
     * Approch O(n) time and space to store res string.
     */
    static String solution(String s) {

        // res string
        String res = "";

        // to store single word from end
        String last = "";

        // reversing words in the string
        for (int i = s.length() - 1; i >= 0; i--) {

            // storing words
            if (s.charAt(i) != ' ') {

                last = s.charAt(i) + last;

            }
            // storing words in res in req. order
            else if (s.charAt(i) == ' ') {
                res = res + last + " ";
                last = "";
            }

            if (i == 0) {
                res = res + last;
            }

        }

        return res;
    }

    /*
     * there is another approach in wihuch ,
     * first we reverse words individually, then reverse the whole string
     */

    public static void main(String[] args) {

        System.out.println(solution("abc"));
    }
}
