package Stacks;

import java.util.Stack;

public class GetMinStack {

    /*
     * Design a stack that can give min element at any point in O(1) time.
     */

    /*
     * Approach 1 : We use a aux stack to store min elements which will take O(n)
     * extra space.
     * 
     * Approach 2 : We use a min variable to store curr min, and whenever we push
     * new min element to the stack, we push it as , x = new min, min = prev min,
     * we push x + (x-min).
     * // we are pushing it this way i.e we can get old min and to handle -ve no.
     * 
     * and whenever we pop current min we get the prev min as ->
     * min = 2*min - st.pop() i.e st.pop() = 2*min - prevMin.
     * min = prevMin.
     * 
     * 
     * ------> If there is only +ve no.,
     * 
     * we can can push new min -> x - min
     * and while we pop curr min, we get old min as min - st.pop().
     */

    // stack to store elements
    Stack<Integer> st;
    int min;

    public GetMinStack() {
        st = new Stack<>();
        min = 0;
    }

    void push(int x) {

        if (st.isEmpty()) {
            st.push(x);
            min = x;
        } else if (x <= min) {
            st.push(2 * x - min);
            min = x;
        } else {
            st.push(x);
        }

    }

    int pop() {

        int t = st.pop();

        if (t <= min) {
            int res = min;
            min = 2 * min - t;
            return res;
        }

        return t;
    }

    int getMin() {
        return min;
    }

    public static void main(String[] args) {

        GetMinStack s = new GetMinStack();

        s.push(1);
        s.push(2);
        System.out.println(s.getMin());
        s.push(3);
        s.push(-1);
        System.out.println(s.getMin());
        System.out.println("pop " + s.pop());
        System.out.println(s.getMin());
        s.push(-2);
        System.out.println(s.getMin());

    }

}
