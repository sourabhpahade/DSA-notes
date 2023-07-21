package Recursion;

public class GenerateAllParanthesis {

    static void solve(int n, String ans, int open, int close) {

        // if open bracket > n || close bracket > open bracket
        // we want open brackets == close brackets
        if (open > n || close > open) {
            return;
        }

        // if ans becomes of length 2*n means we find the valid subsequence
        if (ans.length() == 2 * n) {
            System.out.println(ans);
            return;
        }

        // adding open brackets first
        solve(n, ans + "(", open + 1, close);

        // adding close brackets
        solve(n, ans + ")", open, close + 1);

    }
}
