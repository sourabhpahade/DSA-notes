package Stacks;

/*
 * Implementing stack using array
 */
public class MyStack {

    // Creating fixed sized stack using fixed size array

    static class Stack {

        int capacity; // gives the capacity of stack
        int size; // gives the current size of stack

        int[] container; // creating container used as stack to store int

        public Stack(int capacity) {

            this.capacity = capacity;
            size = 0;
            container = new int[capacity];
        }

        // adding element to stack
        void push(int val) {

            if (size < capacity) {
                container[size] = val;
                size++;
            } else {
                System.out.println("Stack is already full");
            }
        }

        // removing element from stack and returning it
        int pop() {

            int poppedVal = 0;
            if (size > 0) {
                poppedVal = container[size - 1];
                container[size - 1] = 0;
                size--;
            } else {
                System.out.println("Stack is Empty.");
            }

            return poppedVal;
        }

        int peek() {

            if (size > 0) {
                System.out.println(container[size - 1]);
                return container[size - 1];
            } else {
                System.out.println("Stack is Empty.");
                return -1;
            }
        }

        void getCapacity() {
            System.out.println(capacity);
        }

        void getSize() {
            System.out.println(size);
        }
    }

    public static void main(String[] args) {

        Stack st = new Stack(5);

        st.getSize();
        st.peek();

        st.push(1);
        st.peek();

        st.push(2);
        st.peek();

        st.push(3);
        st.peek();

        st.push(4);
        st.peek();

        st.push(5);
        st.peek();
        st.getSize();

        st.push(6);
        st.getSize();

        st.peek();

        st.pop();
        st.getSize();

        st.push(6);
        st.peek();
        st.getSize();

    }
}
