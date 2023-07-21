package Searching;

public class PeakElement {
    /*
     * we have givrn an array we have to find peak element(x)
     * i.e left neightbour <= x >= right neighbour
     * if x is at start then we only check right element, and if at end we check
     * left element
     */
    public int peakElement(int[] a, int n) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Property od peak element
            if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == n - 1 || a[mid] >= a[mid + 1])) {
                return mid;
            }

            // Deciding where to go for search, we go to side of greater element >= a[mid]
            if (a[mid + 1] >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
