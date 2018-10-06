package dp;

public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        int[] aux = new int[nums.length+2];
        int n=0;
        aux[n++]=1;
        for (Integer i:nums){
            if (i>0) aux[n++] = i;
        }
        aux[n]=1;
        // skip all 0 ballons, build aux array with 1 at left and right

        int[][] dp = new int[n+1][n+1];     // dp[i][j] max coins can get from i to j (inclusive), with 0 borders

        for (int dis = 0; dis<n; ++dis){
            for (int start = 1; start+dis<n; ++start){
                int end = start+dis;
                for (int i = start; i<=end; ++i){  // burst i last -> i will remain a border before last
                    int burstThisLast =aux[i]*aux[start-1]*aux[end+1] + dp[start][i-1] + dp[i+1][end];  // points from last + from left, + from right
                    if (burstThisLast > dp[start][end]){
                        dp[start][end] = burstThisLast;
                    }
                }
            }
        }
        return dp[1][n-1];  // 0 in 4 borders
    }
}
