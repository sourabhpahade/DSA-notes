package Recursion;

public class WaysToFormNaturalNumber {

    public static long ways(int n, int i) {

        if (n == 0) {
            return 1;
        }

        int c = 0;

        for (int j = i; j <= n; j++) {
            c += ways(n - j, j + 1);
        }

        return c;

    }
}
