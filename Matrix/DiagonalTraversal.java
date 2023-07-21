
public class DiagonalTraversal {

    /*
     * Given a square matrix we we have to print diagonal traversal of matrix.
     */

    static void traverse(int[][] mat, int n) {

        // start points
        int r = 0;
        int c = n - 1;

        // tracking count of elements printed
        int count = 0;
        int sum = n * n;

        // we run loop until all the elements are traversed
        while (count < sum) {

            // tracking if a particular row is full traversed
            int t = 0;

            // current row
            int i = r;

            // printing diagonals
            for (int j = c; j < n; j++) {

                System.out.print(mat[i][j] + " ");
                i++;
                count++;
                t++;
            }

            // checking if the current row is traversed then we move to another row
            // and dec. col as right part is printed
            if (t == n) {
                r++;
                n--;
            }

            // shifting columns
            if (c > 0) {
                c--;
            }
        }
    }

    public static void main(String[] args) {

        int[][] mat = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        traverse(mat, 3);
    }
}
