package Queue;

/**
 * ImplementaionUsingArray
 */

/*
 * Implementation using normal fixed sized array:
 * enque operation -> O(1) time
 * dequeue operation -> O(n) time
 * 
 * Implementation using circular fixed sized array:
 * enque operation -> O(1) time
 * dequeue operation -> O(n) time
 */

class Queue {

    private int[] arr;
    private int size;
    private int cap;
    private int front;

    public Queue(int cap) {
        this.cap = cap;
        arr = new int[cap];
        size = 0;
        front = -1;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean isFull() {
        return size == cap;
    }

    int getFront() {
        return isEmpty() == true ? -1 : front;
    }

    int getRear() {
        return isEmpty() == true ? -1 : (front + size - 1) % cap;
    }

    void enque(int x) {

        if (isFull()) {
            return;
        }

        int rear = getRear();
        rear = (rear + 1) % cap;
        arr[rear] = x;

        size++;
    }

    void dequeue() {

        if (isEmpty()) {
            return;
        }

        front = (front + 1) % cap;
        size--;
    }
}

public class ImplementaionUsingArray {

    public static void main(String[] args) {

    }

}