package Sorting;

import java.util.ArrayList;
import java.util.Arrays;

class Pair implements Comparable<Pair> {

    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return this.start - o.start;
    }

}

public class MergeOverlappingIntervals {

    /*
     * In this we have given array of pairs,
     * each pair is a interval having start and end times
     * we have to merge intervals.
     * 
     * i.e start or end of an interval lies between another intervals
     */

    // func to print the merged intervals
    static ArrayList<Pair> mergeIntervals(Pair[] arr) {

        ArrayList<Pair> pairs = new ArrayList<>();

        // 1st we have to sort
        Arrays.sort(arr);

        // traversing the Pair arr

        // storing 1st interval
        int s = arr[0].start;
        int e = arr[0].end;

        for (int i = 1; i < arr.length; i++) {

            Pair curr = arr[i];

            // checking if curr interval can be merged with prev one
            if (curr.start <= e) {
                e = Math.max(curr.end, e);
            }
            // if not then we just add the prev interval into res
            else {
                pairs.add(new Pair(s, e));
                s = curr.start;
                e = curr.end;
            }

        }

        // adding last interval
        pairs.add(new Pair(s, e));

        return pairs;
    }

    public static void main(String[] args) {

        Pair[] a = { new Pair(7, 9),
                new Pair(6, 10),
                new Pair(4, 5),
                new Pair(1, 3),
                new Pair(2, 4) };

        mergeIntervals(a);
    }
}
