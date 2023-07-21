
class Solution {
    // Function to modify the matrix such that if a matrix cell matrix[i][j]
    // is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int m[][]) {

        int r = m.length;
        int c = m[0].length;

        // Storing the location of 1
        boolean[] rowFlag = new boolean[r];
        boolean[] colFlag = new boolean[c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (m[i][j] == 1) {
                    rowFlag[i] = true;
                    colFlag[j] = true;
                }
            }
        }

        // setting rows to 1
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (rowFlag[i]) {
                    m[i][j] = 1;
                }
            }
        }

        // setting column to 1
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {

                if (colFlag[i]) {
                    m[j][i] = 1;
                }
            }
        }
    }
}
