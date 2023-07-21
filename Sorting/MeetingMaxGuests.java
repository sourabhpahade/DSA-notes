package Sorting;

import java.util.Arrays;

public class MeetingMaxGuests {

    /*
     * In this we have given two array -> arrival[] , departure[]
     * These two arrays give info about the arrival and departure time of a
     * particular guest.
     * 
     * We need to find the max. no. of guest we can meet by attending the party for
     * min time.
     * 
     */

    /*
     * Approach :
     * 
     * we first sort the both arrays so we can make a time line of times so we can
     * know at which time how many no. of guests are present in the party.
     * 
     * while traversing both arrays we inc and dec the count of present guests by
     * watching the arrival, departure time
     * 
     */

    static int maxMeets(int[] arrive, int[] depart) {

        // length of both arrays are same
        int n = arrive.length;

        // sorting arrays
        Arrays.sort(arrive);
        Arrays.sort(depart);

        int res = 1;

        // tracking curr present guests
        int curr = 1;

        // pointers to traverse arrays
        int i = 0;
        int j = 0;

        while (i < n && j < n) {

            // updating present guests at given time
            if (arrive[i] <= depart[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }

            res = Math.max(res, curr);
        }

        return res;
    }
}
