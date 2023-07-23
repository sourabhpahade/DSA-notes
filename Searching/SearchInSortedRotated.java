package Searching;

/*
 * Given an array i.e array is sorted and rotated any number of times. we have to search x in it.
 */
public class SearchInSortedRotated {

    // {10,20,30,40,50,8,9} , x

    static int search(int[] a, int x) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (a[mid] == x) {
                return mid;
            }

            // checking if array is sorted from low to mid or not
            if ((a[low] <= a[mid])) {

                // checking is x is present in [low,mid-1]
                if (x >= a[low] && x < a[mid]) {
                    high = mid - 1;
                }
                // if not present we go to right part
                else {
                    low = mid + 1;
                }

            }
            // right part is sorted
            else {

                // checking is x is present in [mid+1,high]
                if (x > a[mid] && x <= a[high]) {
                    low = mid + 1;
                }
                // if not present we go to left part
                else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = { 3,1};

        System.out.println(search(a, 1));
    }
}
