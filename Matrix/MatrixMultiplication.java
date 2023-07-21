
public class MatrixMultiplication {

    static int[][] solve(int[][] a, int[][] b) {

        /*
         * Multiplication of two matrices is possible i.e a[r1][c1], b[r2][c2] => c1 ==
         * r2
         * And the product of matrices will be of ( r1 x c2 ) dimensions
         */
        if (a[0].length != b.length) {

            int[][] res = new int[1][1];
            res[0][0] = -1;
            return res;
        }

        int[][] res = new int[a.length][b[0].length];

        for (int r = 0; r < a.length; r++) {

            for (int c1 = 0; c1 < b[0].length; c1++) {

                for (int r1 = 0; r1 < b.length; r1++) {

                    res[r][c1] += a[r][r1] * b[r1][c1];

                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
