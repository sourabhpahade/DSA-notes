package String;

/*
 *  String s1 is anagram of String s2 if all char in s1 also present in s2
 */
public class AnagramCheck {

    /*
     * Approach 1: O(n sq) => check each char of s1 present in s2 or not.
     * 
     * Approch 2: O(nlogn) => convert strings into char array sort them then make
     * two new strings to store the sorted char arrays, check if these new strings
     * is equal or not
     */

    /*
     * Better Approach: O(n) => using aux. freq. array of size 256
     */

    static boolean anagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        // creating freq array of 256 len, we can also use 26 len if the input contains
        // only english alphabets
        int[] freq = new int[256];

        for (int i = 0; i < s1.length(); i++) {

            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;

        }

        // if there is any value != 0 we return false
        for (int i = 0; i < 256; i++) {

            if (freq[i] != 0)
                return false;

        }

        return true;
    }

    public static void main(String[] args) {

        String s1 = "sourabh";
        String s2 = "hbaroas";

        System.out.println(anagram(s1, s2));
    }
}
