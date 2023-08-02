package Stacks;

import java.util.Stack;

/**
 * StockSpan : We have to find span of consecutive no. which are <= a[i]. at
 * each index
 */
public class StockSpan {

    /*
     * Naive : O(n sq) -> check for span for each index by traversing back.
     */

    /*
     * Optimized : theta(n) time, O(n) space
     * using stack -> we use stack to store no. whenever we find that
     * span == 1 at any index, this will optimize the backward traversal.
     */

    static int[] sol(int[] arr) {

        int n = arr.length;

        int[] ans = new int[n];

        ans[0] = 1; // as span will 1 for 1st element

        // creating stack to store index of greater elements at left of index i
        Stack<Integer> st = new Stack<>();

        for (int i = 1; i < n; i++) {

            // pushing left greater element
            if (arr[i - 1] > arr[i]) {
                st.push(i - 1);
                ans[i] = 1;
            }
            // finding idx of left most greater element so we can find the length of span
            // for index i
            else {
                while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }

                // if a[i] is the greatest element
                if (st.isEmpty()) {
                    ans[i] = i + 1;
                } else {
                    ans[i] = i - st.peek();
                }

                // pushing curr element
                st.push(i);

            }
        }

        return ans;
    }

}