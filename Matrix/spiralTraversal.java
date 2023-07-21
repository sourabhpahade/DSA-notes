
import java.util.*;

class Test {
    static ArrayList<Integer> spirallyTraverse(int a[][], int r, int c) {
        // code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        int top = 0;
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                res.add(a[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                res.add(a[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    res.add(a[bottom][i]);
                }
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(a[i][left]);
                }
            }
            left++;

        }

        return res;

    }

}