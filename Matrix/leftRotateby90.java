
public class leftRotateby90 {

    static void rotateby90(int matrix[][], int n) {

        // 1st transpose the matrix
        for (int r = 0; r < n; r++) {

            for (int c = r + 1; c < n; c++) {

                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }

        // Now reverse the rows till middle
        for (int r = 0; r < n / 2; r++) {

            for (int c = 0; c < n; c++) {

                int temp = matrix[r][c];
                matrix[r][c] = matrix[n - 1 - r][c];
                matrix[n - 1 - r][c] = temp;
            }
        }
    }

}
