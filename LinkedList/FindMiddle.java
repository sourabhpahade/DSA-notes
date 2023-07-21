package LinkedList;

import java.util.Scanner;

public class FindMiddle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < n; i++) {

            list.head = list.insertEnd(list.head, sc.nextInt());
        }

        sc.close();

        list.printNodes(list.head);

        System.out.println(middle(list.head));
    }

    static int middle(SinglyLinkedList.Node head) {

        if (head == null) {
            System.out.println("null");
        }

        // we use two nodes pointer slow and fast , slow moves 1 step, falst moves 2
        // step
        SinglyLinkedList.Node slow = head;
        SinglyLinkedList.Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

        }

        return slow.data;
    }

}
