package String;

/**
 * PalindromeCheck
 */
public class PalindromeCheck {

    // Iterative solution
    static boolean solution(String s) {

        // taking start index and last index
        int i = 0;
        int j = s.length() - 1;

        // checking palindrome by cheking s[i] == s[j]
        while (i <= j) {

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    // recursive solution

    static boolean recursiveSol(String s, int start, int end) {

        // base case if run if (start <= end)
        if (start > end) {
            return true;
        }

        // general solution, changing start++,end-- && checking s[start] == s[end]
        // at each recursive call if yhis condition gets false , func returns false
        return recursiveSol(s, start + 1, end - 1) && s.charAt(start) == s.charAt(end);

    }

    public static void main(String[] args) {

        String s = "aabaa";

        System.out.println(recursiveSol(s, 0, s.length() - 1));

    }
}