
class Solution {
    // Function to search a given number in row-column sorted matrix.
    static boolean search(int a[][], int n, int m, int x) {

        // we start from top right corner
        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {

            // if x == a[i][j] we return

            if (a[i][j] == x)
                return true;

            // if x>a[i][j] we go downwards else we go left

            if (x > a[i][j]) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}