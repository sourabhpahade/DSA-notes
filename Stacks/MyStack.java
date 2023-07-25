package Stacks;

import java.util.*;

/*
 * Implementing stack
 */
public class MyStack {

    // fixed sized stack using fixed size array
    static class FixedStack {

        int capacity; // gives the capacity of stack
        int size; // gives the current size of stack

        int[] container; // creating container used as stack to store int

        public FixedStack(int capacity) {

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

    // dynamic sized stack using ArrayList
    static class DynamicStack {

        // container for stack
        ArrayList<Integer> st;

        public DynamicStack() {
            st = new ArrayList<>();
        }

        // push method
        public void push(int val) {
            st.add(val);
        }

        // pop method
        public int pop() {
            return st.remove(st.size() - 1);
        }

        // peek method
        public int peek() {
            return st.get(st.size() - 1);
        }

        // isEmpty method
        public boolean isEmpty() {
            return st.isEmpty();
        }

        // size methode
        public int size() {
            return st.size();
        }

    }

    // stack using LinkedList
    static class Stack {

        static class Node {

            int data;
            Node next;

            public Node(int data) {
                this.data = data;
            }
        }

        Node head;
        int size;

        public Stack() {
            size = 0;
        }

        // push
        public void push(int val) {

            Node temp = new Node(val);
            temp.next = head;
            head = temp;

            size++;
        }

        // pop
        public int pop() {

            int res = Integer.MAX_VALUE;

            if (head != null) {
                res = head.data;
                Node temp = head.next;
                head.next = null;
                head = temp;
                size--;
            }

            return res;
        }

        // peek
        public int peek() {

            if (head != null) {
                return head.data;
            }

            return -1;
        }

        // isEmpty
        public boolean isEmpty() {
            if (size == 0)
                return true;

            return false;
        }

        // size
        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {

    }
}
