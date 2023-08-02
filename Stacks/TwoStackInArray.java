package Stacks;

public class TwoStackInArray {

    /*
     * Implement Two Stacks in one array
     */

    int[] arr;
    int cap;

    int top1;
    int top2;

    public TwoStackInArray(int cap) {
        this.cap = cap;
        arr = new int[cap];

        // filling one stack from begin ans other from end of array
        top1 = -1;
        top2 = cap;
    }

    // push 1
    void push1(int a) {

        if (top1 + 1 < top2) {
            top1++;
            arr[top1] = a;
        }
    }

    // push 2
    void push2(int a) {

        if (top2 - 1 > top1) {
            top2--;
            arr[top2] = a;
        }
    }

    // pop1
    int pop1() {

        int res = -1;
        if (top1 != -1) {
            res = arr[top1];
            top1--;
        }
        return res;
    }

    // pop2
    int pop2() {

        int res = -1;
        if (top2 != cap) {
            res = arr[top2];
            top2++;
        }
        return res;
    }

    // size1
    int size1() {
        return top1;
    }

    // size2
    int size2() {
        return cap - top2;
    }

}
