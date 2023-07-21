
import java.util.ArrayList;

public class boundaryTraversal {

    static ArrayList<Integer> bTraversal(int a[][], int n, int m) {
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int r = 0; r < n; r++) {

            for (int c = 0; c < m; c++) {

                if (r == 0) {
                    res.add(a[r][c]);
                } else if (r == n - 1) {
                    res.add(a[r][m - c - 1]);
                } else {
                    res.add(a[r][m - 1]);
                    break;
                }
            }

        }

        if (n > 2 && m > 1) {
            for (int r = n - 2; r >= 1; r--)
                res.add(a[r][0]);
        }

        return res;
    }
}
