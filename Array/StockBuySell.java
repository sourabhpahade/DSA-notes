package Array;

/*
 * In this we have given a array of prices of ith days
 * We have to find the best time to buy and sell the stocks
 * so that we can gain max profit.
 */
public class StockBuySell {
    // There are multiple variation of this que.

    /*
     * Simple Variation we just have to find max profit
     * 
     * Approach: we sell the stock when see rise in price and buy day before selling
     * day
     */

    static int var1(int[] a) {

        // int res = 0;
        // int buy = 0;
        // int n = a.length;

        // for(int i=1;i<n-1;i++){
        // if(a[i]<a[buy]){
        // buy=i;
        // }else if(a[i+1]<a[i]){
        // res+=a[i]-a[buy];
        // buy=i+1;
        // }else if(i==n-2){
        // res+=a[i+1]-a[buy];
        // }
        // }
        // return res;

        int n = a.length;

        int res = 0;

        for (int i = 0; i < n - 1; i++) {

            if (a[i + 1] > a[i]) {

                // sell - buy
                res += a[i + 1] - a[i];
            }
        }

        return res;
    }

}
