package String;

public class Parenthesis {

    /*
     * count parenthesis to make the sequence as valid parenthesis
     */

    static int MinimumParantheses(String s) {

        // tracking open and close brackets
        int open = 0;
        int close = 0;

        // finding unbalanced parenthesis
        for (int i = 0; i < s.length(); i++) {

            // whenever we encounter open we increase open count
            if (s.charAt(i) == '(') {
                open++;
            } else {

                // if there is no open parenthesis, so we can't close it
                if (open == 0) {
                    close++;
                }
                // if there is any open parenthesis then we close it
                else {
                    open--;
                }
            }
        }
        return open + close;
    }

    /*
     * In this we have to check if the given sequence can become a valid parenthesis
     * by swapping any two char any no. of time
     */

    public boolean CanBalance(String s) {

        int count = 0; // Count of unmatched opening parentheses

        boolean flag = false; // for checking if we encounter the opening parathesis before closing

        for (char c : s.toCharArray()) {

            if (c == '(') {
                count++; // Increment count for opening parenthesis
                flag = true;
            } else if (c == ')') {

                // checking if we encountered a closing parenthesis without having open
                // parenthesis
                if (count == 0 && flag == true) {
                    return false; // Unmatched closing parenthesis
                }
                count--; // Decrement count for matched closing parenthesis
            }
        }

        return count == 0; // All opening parentheses are matched
    }

    /*
     * In this we have given three types of brackets (),{},[] we hae to check for
     * valid parenthesis
     */

    public boolean isValid(String s) {

        char[] c = s.toCharArray();

        // to track current open brackts
        int prev = -1;

        for (int i = 0; i < c.length; i++) {

            // storing open brackets
            if (prev < 0 || !matched(c[prev], c[i])) {
                prev++;
                c[prev] = c[i];
            }
            // closing open brackets
            else {
                prev--;
            }
        }

        // checking if all brackets are closed
        return prev == -1;
    }

    static boolean matched(char c1, char c2) {

        if (c1 == '(' && c2 == ')')
            return true;
        if (c1 == '{' && c2 == '}')
            return true;
        if (c1 == '[' && c2 == ']')
            return true;

        return false;
    }
}
