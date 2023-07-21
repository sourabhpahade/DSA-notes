package Array;

/**
 * EquilibriumPoint : Given an array we have to find a point in array at which
 * sum(a[0] to a[k]) == sum(a[k+1] to a[n-1])
 */
public class EquilibriumPoint {

    public static int equilibriumPoint(long arr[], int n) {

        int rs = 0;

        for (int i = 0; i < n; i++)
            rs += arr[i];

        int ls = 0;
        for (int i = 0; i < n; i++) {

            rs -= arr[i];

            if (ls == rs)
                return i + 1;

            ls += arr[i];

        }

        return -1;
    }
}