package combination_permutation;

/*
You are given coins of different denominations and a total amount of money.
Write a function to compute the number of combinations that make up that amount.
You may assume that you have infinite number of each kind of coin.

Note: You can assume that
0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer


Example 1:
Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1

Example 2:
Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.

Example 3:
Input: amount = 10, coins = [10]
Output: 1
 */

public class CoinChange2_518 {

    public int change(int amount, int[] coins) {
        int[] m = new int[amount+1];
        m[0] = 1;
        for (int activeCoin = 1; activeCoin<=coins.length; ++activeCoin){
            int val = coins[activeCoin-1];
            for (int total=val; total<=amount; ++total){
                m[total] += m[total-val];
            }
            /* optimization for-loop from:
            for (int total=1; total<=amount; ++total){
                if (val<=total) m[total] += m[total-val];
            }
             */
        }
        return m[amount];
    }

    public static int change_2d(int amount, int[] coins) {
        if(amount==0) return 1;
        int[][] m = new int[amount+1][coins.length+1];
        for (int i=1; i<m[0].length; ++i) m[0][i]=1;
        for (int x=1; x<=amount; ++x){
            for (int y=1; y<m[x].length; ++y){
                m[x][y] = m[x][y-1];
                if (coins[y-1]<=x){
                    m[x][y] += m[x-coins[y-1]][y];
                }

            }
        }
        return m[amount][coins.length];
    }
}
