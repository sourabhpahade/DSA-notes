package Stacks;

import java.util.Stack;

public class LargestAreaHistogram {

    /*
     * Given an array in which each index is a histogram having height a[i].
     * we need to find largest rectangular combining the histograms
     */

    /*
     * Logic :
     * 
     * 1. Find the span of elements which are >= a[i]. find this span on both
     * sides left and right.
     * 
     * 2. Get the breadth of largest histogram by calculating right[i]-left[i]+1.
     * 
     * 3. Find the area of largest histogram at each index and compare to curr res.
     */

    /*
     * Naive Approach : O(n sq.) solution
     */

    /*
     * Optimized 1 : theta(n) time, theta n space : using two aux stacks and two aux
     * array.
     */

    static int sol(int[] arr) {

        int n = arr.length;

        int res = 0;

        int[] left = leftSpan(arr);
        int[] right = rightSpan(arr);

        for (int i = 0; i < n; i++) {
            int curr = arr[i] * (right[i] - left[i] + 1);
            res = Math.max(res, curr);
        }

        return res;
    }

    // left span
    static int[] leftSpan(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        ans[0] = 0;
        st.push(0);

        for (int i = 1; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            int temp = st.isEmpty() == true ? 0 : st.peek() + 1;
            ans[i] = temp;
            st.push(i);
        }

        return ans;
    }

    // rigth span
    static int[] rightSpan(int[] arr) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        int[] ans = new int[n];
        ans[n - 1] = n - 1;
        st.push(n - 1);

        for (int i = n - 2; i >= 0; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            int temp = st.isEmpty() == true ? n - 1 : st.peek() - 1;
            ans[i] = temp;
            st.push(i);
        }

        return ans;
    }

    /*
     * Optimized 2 : using only one stack.
     * 
     * Idea is to store prev smaller candidates in stack and we calculate the area
     * whenever we encounter a element which is next smaller.
     */

    static int sol2(int[] arr) {

        int res = 0;
        int n = arr.length;

        // creating stack to store prev smaller candidate
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {

                // here i is the next smaller for upcoming elements in stack if they are greater
                // curr bar is tp
                int tp = st.pop();

                // calculating max area for tp
                int curr = arr[tp] * (st.isEmpty() == true ? i : i - st.peek() - 1);

                // updating res
                res = Math.max(res, curr);
            }

            // pushing prev smaller candidates
            st.push(i);
        }

        // processing rest of the element in stack
        while (!st.isEmpty()) {

            int tp = st.pop();
            int curr = arr[tp] * (st.isEmpty() == true ? n : n - st.peek() - 1);
            res = Math.max(res, curr);

        }

        return res;
    }

}
