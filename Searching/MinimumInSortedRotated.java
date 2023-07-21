package Searching;

public class MinimumInSortedRotated {

    /*
     * we have given sorted array , it can be rotated left and right any no of side
     * we have to find minimum number in array
     */

    /*
     * Approach : using binary search
     * Obervation -> mid will be min element if(a[mid] < a[mid-1]) or mid+1 can be
     * min if (a[mid+1] < a[mid])
     * 
     * Deciding where to search -> we search in unsorted part
     */

    static int minSearch(int[] a, int low, int high) {

        // IF ARRAY IN NOT ROTATED
        if (a[low] < a[high]) {
            return a[0];
        }

        int mid = low + (high - low) / 2;
        // if this happens means we have find the min
        if (low == high) {
            return a[low];
        }

        // Properties of min element
        if (mid > low && a[mid] < a[mid - 1]) {
            return a[mid];
        }

        if (mid < high && a[mid + 1] < a[mid]) {
            return a[mid + 1];
        }

        // sorted from mid -> high, so we go to left
        if (a[mid] < a[high]) {
            return minSearch(a, low, mid - 1);
        }
        // else we go to right
        return minSearch(a, mid + 1, high);
    }
}
