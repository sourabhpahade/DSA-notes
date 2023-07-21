package Recursion;

public class MazeProblems {

    /*
     * Problem 1:
     * 
     * we have given a grid of n*m -> we have to reach n-1,m-1.
     * 
     * we have allowed to move 1 to any no. of moves in any direction
     * 
     * Order of moves -> horizontal -> vertical -> diagonal
     */
    public static void printMazePaths(int i, int j, int n, int m, String psf) {

        // base case -> when we have reached the destination
        if (i == n && j == m) {
            System.out.println(psf);
        }

        // we are using loop to get the max move we can make in a particular direction

        // max horizontal move from curr pos(i,j) is (m-j)
        // moving horizontally in every valid possible moves
        for (int k = 1; k <= m - j; k++) {
            printMazePaths(i, j + k, n, m, psf + "h" + k);
        }

        // max vertical move from curr pos(i,j) is (n-i)
        // moving vertically in every valid possible moves
        for (int k = 1; k <= n - i; k++) {
            printMazePaths(i + k, j, n, m, psf + "v" + k);
        }

        // max diagonal move from curr pos(i,j) is min((n-i),(m-j))
        // moving diagonally in every valid possible moves
        for (int k = 1; k <= Math.min(n - i, m - j); k++) {
            printMazePaths(i + k, j + k, n, m, psf + "d" + k);
        }

    }

    /*
     * Problem 2:
     * 
     * Given a grid with values -> we have to reach n-1,m-1 with sum div by k
     * 
     */

    static void print(int i, int j, int n, int m, int sum, String psf, int[][] a) {

        // if we goes out of the grid
        if (i == n || j == m) {
            return;
        }

        // if we encounter -1
        if (a[i][j] == -1) {
            return;
        }

        // if we succesfully reached the the destination
        if (i == n - 1 && j == m - 1) {
            if ((sum + a[i][j]) % 5 == 0) {
                System.out.println(psf);
            }
        }
        sum += a[i][j];
        // moving horizontally
        print(i, j + 1, n, m, sum, psf + "h", a);

        // moving diagonally
        print(i + 1, j + 1, n, m, sum, psf + "d", a);

        // moving vertically
        print(i + 1, j, n, m, sum, psf + "v", a);

    }

    /*
     * Problem 3:
     * 
     * Given a grid -> we have to reach n-1,m-1 and we can move in every
     * direction,Another condition is we in the path we can not repeat the previous.
     * cells
     * 
     * we have to count the no. of ways
     */

    static int[][] vis;

    static int countAllPath(int n, int m) {
        // Write your code here
        vis = new int[n][m];
        return count(0, 0, n, m);

    }

    static int count(int i, int j, int n, int m) {

        // if goes outside the gird
        if (i < 0 || j < 0 || i == n || j == m) {
            return 0;
        }

        // if goes back to prev cell
        if (vis[i][j] == 1) {
            return 0;
        }

        // if reached destination
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        int c = 0;

        vis[i][j] = 1;

        c += count(i, j - 1, n, m);
        c += count(i, j + 1, n, m);

        // vertical moves
        c += count(i - 1, j, n, m);
        c += count(i + 1, j, n, m);

        // diagonal
        c += count(i + 1, j + 1, n, m);
        c += count(i - 1, j - 1, n, m);
        c += count(i - 1, j + 1, n, m);
        c += count(i + 1, j - 1, n, m);

        vis[i][j] = 0;

        return c;
    }

    // ------------------------------------------------------------------------------
    public static void main(String[] args) {

    }
}
