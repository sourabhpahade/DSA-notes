package Recursion;

public class CoinsPermutaion {

    /*
     * Problem : we have given an array containing various coins and a given amount,
     * we have to print combination of unique coins whose sum == amt
     */

    static void solve(int[] coins, int amt, String ans, boolean[] vis) {

        // if sum of coins become > amt
        if (amt < 0) {
            return;
        }

        // valid combination of coins
        if (amt == 0) {
            System.out.println(ans);
            return;
        }

        // running loop to traverse full array in each call
        for (int i = 0; i < coins.length; i++) {

            // if the current coin if not used/visited we make calls to find combination
            if (vis[i] == false) {

                // marking current coins used
                vis[i] = true;

                // calling to find permutation for next coin
                solve(coins, amt - coins[i], ans + coins[i] + " ", vis);

                // when the all the combination for the current coin is checked we unmark the
                // used coin to check combination for next coins
                vis[i] = false;

            }
        }
    }
}
