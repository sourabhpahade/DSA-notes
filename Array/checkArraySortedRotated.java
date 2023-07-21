
package Array;

/**
 * checkArraySortedRotated
 */

public class checkArraySortedRotated {

    /*
     * DECIDE WHEATHER MAYBE THE ARRAY IS SORTED INC. OR DEC
     * 
     * RUN A LOOP FROM 1-N: check for rotation by finding min in inc order and max
     * in dec
     * check for sort by checkin a[i] and a[i-1]
     * 
     */
    public static boolean checkRotatedAndSorted(int a[], int n) {

        int low = a[0];
        int high = a[n - 1];

        boolean res = false;

        if (low > high) {

            for (int i = 1; i < n; i++) {

                if (i == n - 1 && a[i] < a[i - 1] && res == false) {

                    return true;

                } else if (a[i] < a[i - 1] && a[i] < a[i + 1]) {

                    if (res == false) {
                        res = true;
                    } else if (res) {
                        return false;
                    }

                } else if (a[i] < a[i - 1]) {
                    return false;
                }
            }
        }

        if (low < high) {

            for (int i = 1; i < n; i++) {

                if (i == n - 1 && a[i] > a[i - 1] && res == false) {

                    return true;

                } else if (a[i] > a[i - 1] && a[i] > a[i + 1]) {

                    if (res == false) {
                        res = true;
                    } else if (res) {
                        return false;
                    }

                } else if (a[i] > a[i - 1]) {
                    return false;
                }
            }

        }

        return res;
    }

}
