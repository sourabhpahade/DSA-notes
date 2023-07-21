package Array;

/**
 * ArrayAddition : we have given two arrays of diffrentsize representing two
 * numbers we have to add these numbers
 */
public class ArrayAddition {

    // function to add two numbers stored in array
    static int[] add(int[] n1, int[] n2) {

        // length of both arrays
        int n = n1.length;
        int m = n2.length;

        int carry = 0;
        int big = n - 1;
        int small = m - 1;

        // making res array
        int[] res = new int[n];

        while (big >= 0) {

            int temp = 0;

            if (small >= 0) {
                temp = n1[big] + n2[small] + carry;
                carry = 0;
            } else {
                temp = n1[big] + carry;
                carry = 0;
            }

            if (temp > 9) {
                res[big] = temp % 10;
                carry = temp / 10;
            } else {
                res[big] = temp;
            }

            small--;
            big--;

        }

        if (carry > 0) {
            int[] res1 = new int[n + 1];
            res1[0] = carry;
            for (int i = 0; i < n; i++) {
                res1[i + 1] = res[i];
            }
            return res1;
        }

        return res;

    }

    // wrapper func to handle big,small array case
    static int[] calcSum(int[] a, int[] b) {

        if (a.length >= b.length) {
            return add(a, b);
        }
        return add(b, a);
    }

    public static void main(String[] args) {

        int[] n1 = { 1, 2, 3 };
        int[] n2 = { 9, 9, 9, 9 };

        int[] res = calcSum(n1, n2);

        for (int x : res) {
            System.out.print(x + " ");
        }
    }
}