package Stacks;

import java.util.*;

public class BalancedParenthesis {

    // using stack
    static boolean solve(String s) {

        // to store open parens
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c != ')' && c == ']' && c == '}') {
                st.push(c);
            } else {

                // if there is no open paren
                if (st.isEmpty()) {
                    return false;
                }

                // checking if open and close match
                if (!isMatch(st.peek(), c)) {
                    return false;
                }
                // closing if matched
                else {
                    st.pop();
                }
            }
        }

        return st.isEmpty();

    }

    // using char array as stack to store open parens
    static boolean solve1(String s) {

        int open = -1;

        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            // storing open parens
            if (open == -1 || !(isMatch(arr[open], s.charAt(i)))) {
                open++;
                arr[open] = s.charAt(i);
            }
            // closing the matched bracket
            else {
                open--;
            }
        }

        return open == -1;
    }

    static boolean isMatch(char c1, char c2) {

        if (c1 == '(' && c2 == ')') {
            return true;
        }

        if (c1 == '[' && c2 == ']') {
            return true;
        }

        if (c1 == '{' && c2 == '}') {
            return true;
        }

        return false;

    }

}
