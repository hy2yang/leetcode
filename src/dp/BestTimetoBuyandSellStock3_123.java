package dp;
/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
public class BestTimetoBuyandSellStock3_123 {
    
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2) return 0;
        int[] dp = new int[prices.length];
        int t;
        for (int i=1;i<=2;++i) {
            t=dp[0]-prices[0];
            for (int j=1;j<dp.length;++j) {                
                t=Math.max(t, dp[j]-prices[j]);  
                dp[j]=Math.max(dp[j-1], (t+prices[j]));
            }
        }
        return dp[prices.length-1];
    }

}

//dpProfit[t][i]: maximum Profit using at most t transactions up to day i (including day i)
//dpProfit[t][i] = max(dpProfit[t][i - 1], prices[i] - prices[j] + dpProfit[t - 1][j]) for all j in range [0, i - 1]
//             = max(dpProfit[t][i - 1], prices[i] + max(dpProfit[t - 1][j] - prices[j])) for all j in range [0, i - 1]
//             = max(dpProfit[t][i - 1], prices[i] + max prev [t - 1] trans profit at the corresponding j in range [0, i - 1] less price at j)
//                                                   maxPreProfitLessI inside loop iterations
//                                                   Note: subtracting price at j is for the last additional transaction to sell at day i