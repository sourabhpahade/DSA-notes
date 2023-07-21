
package Recursion;

/**
 * TowerOfHanoi
 */
public class TowerOfHanoi {

    // Q) Tower of Hanoi but also return no. of steps needed to finish.
    // => time complexity O(2^n)

    public long toh(int N, int from, int to, int aux) {

        if (N == 1) {
            System.out.println("move disk " + 1 + " from rod " + from + " to rod " + to);
            return 1;
        }
        long count = toh(N - 1, from, aux, to) + 1;
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        toh(N - 1, aux, to, from);
        return 2 * count - 1;
    }

}
