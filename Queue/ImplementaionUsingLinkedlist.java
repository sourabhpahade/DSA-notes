package Queue;

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class Queue {

    Node front;
    Node rear;
    int size;

    public Queue() {
        front = null;
        rear = null;
        size = 0;
    }

    void enque(int x) {

        Node temp = new Node(x);

        if (size == 0) {
            front = temp;
            rear = front;
        } else {
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    void deque() {

        if (size == 0) {
            return;
        }

        front = front.next;
        size--;

        if (size == 0) {
            rear = null;
        }
    }

    int getFront() {

        if (size == 0) {
            System.out.println("queue is empty");
            return -1;
        }

        return front.data;
    }

    int getRear() {

        if (size == 0) {
            System.out.println("queue is empty");
            return -1;
        }

        return rear.data;
    }

    int getSize() {
        return size;
    }
}

public class ImplementaionUsingLinkedlist {

    public static void main(String[] args) {

    }
}
