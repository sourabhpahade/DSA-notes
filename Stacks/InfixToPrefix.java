package Stacks;

import java.util.Stack;

public class InfixToPrefix {

    /*
     * Approach is same as infix to postfix,
     * change is that -> in this we traverse exp right to left
     */

    static int precendence(char c) {

        if (c == '+' || c == '-')
            return 1;
        if (c == '*' || c == '/')
            return 2;
        if (c == '^')
            return 3;

        return 0;
    }

    static String convertToPrefix(String exp) {

        StringBuilder res = new StringBuilder();

        // to store operators
        Stack<Character> st = new Stack<>();

        // traversing from right to left
        for (int i = exp.length() - 1; i >= 0; i--) {

            char c = exp.charAt(i);

            if (c >= 'a' && c <= 'z') {
                res.insert(0, c);
            } else if (c == ')') {
                st.push(c);
            } else if (c == '(') {

                while (st.peek() != ')') {
                    res.insert(0, st.pop());
                }
                st.pop();
            }
            // c is operator
            else {

                if (st.isEmpty() || precendence(c) > precendence(st.peek())) {
                    st.push(c);
                } else {
                    if (precendence(c) < precendence(st.peek())) {

                        while (!st.isEmpty() && precendence(c) < precendence(st.peek())) {
                            System.out.println("hakj");
                            res.insert(0, st.pop());
                        }
                        st.push(c);

                    } else if (precendence(c) == precendence(st.peek())) {

                        if (c == '^' && st.peek() == '^') {
                            res.insert(0, st.pop());
                        }
                        st.push(c);
                    }
                }

            }
        }

        // emptying the stack
        while (!st.isEmpty()) {
            res.insert(0, st.pop());
        }

        return res.toString();
    }

    public static void main(String[] args) {

        String exp = "x^y^z";
        System.out.println(convertToPrefix(exp));
    }

}
