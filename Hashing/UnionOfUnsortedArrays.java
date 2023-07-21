package Hashing;

import java.util.ArrayList;
import java.util.HashSet;

public class UnionOfUnsortedArrays {

    /*
     * This is Naive approach with time complexity O(m*m + n*(m+n))
     * space complexity of theta(m+n)
     */
    // Creating Distinct Array
    static void distinctArray(ArrayList<Integer> dist, int[] a) {

        for (int i = 0; i < a.length; i++) {

            if (dist.isEmpty()) {

                dist.add(a[i]);

            } else {

                boolean isPresent = false;

                for (int j = 0; j < dist.size(); j++) {

                    if (a[i] == dist.get(j)) {

                        isPresent = true;
                        break;

                    }
                }

                if (!isPresent) {

                    dist.add(a[i]);

                }
            }

        }
    }

    // Finding union of arrays
    static int union(int[] a, int[] b) {

        ArrayList<Integer> dist = new ArrayList<>();

        distinctArray(dist, a);
        distinctArray(dist, b);

        for (int i = 0; i < dist.size(); i++) {
            System.out.print(dist.get(i) + " ");
        }
        System.out.println();

        return dist.size();
    }

    /*
     * Better Approach Using HashSet with O(n) time and space
     */

    static int unionWithHash(int[] a, int[] b) {

        HashSet<Integer> union = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            union.add(a[i]);
        }

        for (int i = 0; i < b.length; i++) {
            union.add(b[i]);
        }

        return union.size();

    }

    public static void main(String[] args) {

        int[] a = { 1, 1, 3, 4, 5, 5, 7, 8 };
        int[] b = { 1, 2, 2, 2, 6, 7, 7, 9 };

        System.out.println(unionWithHash(a, b));
    }
}
