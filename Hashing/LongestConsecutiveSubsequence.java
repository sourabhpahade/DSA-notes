package Hashing;

import java.util.HashSet;

/*
 * In this problem we have to find longest consecutive subsequence
 * i.e a[] = {1,9,3,4,2,20} => ans is 1,2,3,4 
 */

public class LongestConsecutiveSubsequence {

    /*
     * Approach 1: O(nlogn) => first sort thr array then traverse the array from (1
     * -> n-1) to find
     * the length by checking if (a[i] == a[i-1]+1) count++,
     * else if (a[i]!=a[i-1]) res = max(res,count);count = 1 => this condition
     * also deal with duplicates
     */

    /*
     * Better Approach : O(n) space, time => using hashset to store unique array
     * elements, then we traverse again to find longest subsequence.
     */

    static int solution(int[] a) {

        int res = 1;

        HashSet<Integer> h = new HashSet<>();

        // copying array to hashset
        for (int i = 0; i < a.length; i++) {
            h.add(a[i]);
        }

        // getting the longest conse. subsequence
        for (int x : h) {

            // this means x id the first number in subsequence
            if (!h.contains(x - 1)) {

                int count = 1;

                // counting next elements i.e x+1,x+2....
                while (h.contains(x + count)) {
                    count++;
                }

                res = Math.max(res, count);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = { 2, 6, 1, 9, 4, 5, 3 };

        System.out.println(solution(a));

    }
}
