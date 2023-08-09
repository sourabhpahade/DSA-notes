package Stacks;

import java.util.*;

/**
 * PostFixEvalution
 */
public class PostfixAndInfixEvalution {

    /*
     * Algorithm : Using stack to store operands
     *
     * 1. create stack
     * 2. traverse left to right
     * 3. if curr char x is :
     *
     * 3.1> operand push it in stack
     * 3.2> operator -> pop two operand , calc the res, push res to stack
     *
     * 4. return st.top after traversal
     */

    static int postfixEval(String exp) {

        Stack<Integer> st = new Stack<>();

        String operators = "+-/*^";

        for (char c : exp.toCharArray()) {

            if (c != ' ' && operators.indexOf(c) == -1) {
                st.push(c - '0');
            } else {
                int op2 = st.pop();
                int op1 = st.pop();

                int res = calc(c, op1, op2);

                st.push(res);
            }
        }

        return st.peek();
    }

    static int prefixEval(String exp) {

        Stack<Integer> st = new Stack<>();

        String operators = "+-/*^";

        for (int i = exp.length(); i >= 0; i--) {

            char c = exp.charAt(i);

            if (c != ' ' && operators.indexOf(c) == -1) {
                st.push(c - '0');
            } else {
                int op2 = st.pop();
                int op1 = st.pop();

                int res = calc(c, op1, op2);

                st.push(res);
            }
        }

        return st.peek();
    }

    static int calc(char operator, int op1, int op2) {

        if (operator == '+') {
            return op1 + op2;
        }
        if (operator == '-') {
            return op1 - op2;
        }
        if (operator == '*') {
            return op1 * op2;
        }
        if (operator == '/') {
            return op1 / op2;
        }
        if (operator == '^') {
            return (int) Math.pow(op1, op2);
        }

        return -1;

    }
}
