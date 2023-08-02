package Stacks;

import java.util.Stack;

public class PreviousGreater {

    /*
     * Logic : theta(n) time, O(n) space
     * 
     * we use stack to store the left greater elements while traversing arr left to
     * right.
     */

    static int[] sol(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        // creating stack to store left greater elements
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            int prevGreater = st.isEmpty() == true ? -1 : st.peek();

            ans[i] = prevGreater;

            st.push(arr[i]);

        }

        return ans;

    }
}
