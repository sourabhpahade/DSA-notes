package Array;

/*
 * We have given an array and we have to find the 2nd largest no..
 */
public class SecondLargestelement {

    /*
     * Using 3 pointers one to traverse the array, second to track largest and third
     * to track 2nd largest.
     */
    static int solution(int[] a) {

        int n = a.length;

        // pointer to track 2nd largest
        int res = -1;

        // pointer to track largest
        int max = 0;

        for (int i = 1; i < n; i++) {

            if (a[i] > a[max]) {
                res = max;
                max = i;
            }

            if (a[i] != a[max]) {

                if (res == -1) {
                    res = i;
                } else if (a[i] > a[res]) {
                    res = i;
                }
            }
        }

        return a[res];

    }

    public static void main(String[] args) {

    }
}
