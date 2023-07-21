
import java.util.ArrayList;

public class PascalTriangle {

    // making pascal's triangle for given n height
    static void solve(int n) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> temp = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }

            }
            res.add(temp);
        }

        print(res);

    }

    // print the triangle
    static void print(ArrayList<ArrayList<Integer>> res) {

        for (ArrayList<Integer> x : res) {

            for (int i : x) {

                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {

        solve(5);
    }
}
