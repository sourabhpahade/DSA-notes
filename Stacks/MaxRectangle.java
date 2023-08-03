package Stacks;

public class MaxRectangle {

    /*
     * Given a matrix we have to find a largest sub-matrix having all 1s.
     */

    /*
     * Naive approach : check all matrices with starting point with a cell having 1
     * value.
     */

    /*
     * Efficient approach 1 : Considering each row as histogram.
     * 
     * 1. we calculate largest area rectangle at row.
     * 2. As we move down in rows we add upper cell of each corresponding curr cell
     * if a[curr] == 1, and calculate the largest area rec, and compare.
     */

    static int sol(int[][] mat) {

        int res = LargestAreaHistogram.sol2(mat[0]);

        for (int r = 1; r < mat.length; r++) {

            for (int c = 0; c < mat[0].length; c++) {

                if (mat[r][c] == 1) {
                    mat[r][c] += mat[r - 1][c];
                }
            }

            int curr = LargestAreaHistogram.sol2(mat[r]);
            res = Math.max(res, curr);
        }

        return res;
    }
}
