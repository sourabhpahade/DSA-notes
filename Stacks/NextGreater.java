package Stacks;

import java.util.Stack;

public class NextGreater {

    // Ex :- arr[] = {5,15,10,8,6,12,9,18}

    /*
     * Logic : theta(n) time, O(n) space
     * 
     * We will use stack to store possible next greater elements for current idx i.
     */

    static int[] sol(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        // creating stack to store possible condidate
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            int nextGreater = st.isEmpty() == true ? -1 : st.peek();

            ans[i] = nextGreater;

            st.push(arr[i]);
        }

        return ans;
    }
}
