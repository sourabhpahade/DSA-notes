package Array;

public class SmallestPositiveMissing {

    static int findMissingPositiveNumber(int[] a, int n) {

        // finding if 1 is present or not
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                flag = true;
                break;
            }
        }

        if (!flag)
            return 1;

        // the smallest missing no. will be in range of [1,n].
        // so we mark all numbers > n and <= 0 as 1.

        for (int i = 0; i < n; i++) {
            if (a[i] > n || a[i] <= 0) {
                a[i] = 1;
            }
        }

        // after marking we increase every element by n.
        // now we have only elements from [1,n] so we will access index as
        // a[(a[i] - 1) % n].
        // this will ensure every present element has value greater than n

        for (int i = 0; i < n; i++) {
            a[(a[i] - 1) % n] += n;
        }

        // now we traverse again and if we find any no. <= n, we return i+1;
        for (int i = 0; i < n; i++) {
            if (a[i] <= n)
                return i + 1;
        }

        // if array has elements from [1,n] all present
        return n + 1;

    }
}
