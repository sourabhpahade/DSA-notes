package Searching;

/*
 * we have given a sorted binary array i.e  {0,0,0,0,1,1,1}, we have to count 1s
 */
public class Count1sinBinaryArray {

    static int count1(int[] a, int low, int high) {

        while (low <= high) {

            int mid = (low + high) / 2;

            if (a[mid] < 1) {

                low = mid + 1;

            } else {

                if (mid == 0 || a[mid] != a[mid - 1]) {
                    return a.length - mid;
                } else {
                    high = mid - 1;
                }

            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = { 0, 0, 0 };
        System.out.println(count1(a, 0, a.length - 1));
    }
}
