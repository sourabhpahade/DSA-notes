
public class BoxRotation {

    static char[][] solve(char[][] box) {

        int n = box.length;
        int m = box[0].length;

        print(box, n, m);

        // transpose
        char[][] transpose = new char[m][n];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                transpose[j][i] = box[i][j];

            }

        }

        print(transpose, m, n);

        // rotating 90 deg
        int c1 = 0;
        int c2 = n - 1;

        if (c2 > 0) {

            while (c1 < c2) {

                for (int r = 0; r < m; r++) {

                    char temp = transpose[r][c1];
                    transpose[r][c1] = transpose[r][c2];
                    transpose[r][c2] = temp;

                }

                c1++;
                c2--;
            }

        }

        print(transpose, m, n);

        // swapping stones columnwise
        for (int c = 0; c < n; c++) {

            int count = 0;
            int idx = -1;

            for (int r = 0; r < m; r++) {

                if (transpose[r][c] == '#') {

                    if (idx == -1) {
                        idx = r;
                    }
                    count++;

                } else if (transpose[r][c] == '*') {

                    count = 0;
                    idx = -1;

                } else if (transpose[r][c] == '.') {

                    if (idx != -1) {

                        for (int i = r; r >= idx; i--) {

                            if (count > 0) {
                                transpose[i][c] = '#';
                                count--;
                            } else {
                                transpose[i][c] = '.';

                            }
                        }
                    }
                }
            }

        }

        print(transpose, m, n);

        return transpose;

    }

    static void print(char[][] box, int n, int m) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                System.out.print(box[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {

        char[][] box = { { '#', '.', '.' } };

        solve(box);
    }
}
