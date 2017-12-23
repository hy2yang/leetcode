package dp;

/*
Given a positive integer n, find the least number of 
perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
For example, given n = 12, return 3 because 12 = 4 + 4 + 4; 
given n = 13, return 2 because 13 = 4 + 9.
*/
public class PerfectSquares_279 {

    public int numSquares(int n) {
        if (n<=0) return 0;
        int[] dp=new int[n+1];
        int pre, min;
        
        for (int i=1;i<=n;++i) {
            min=Integer.MAX_VALUE;
            for (int j=1;j*j<=i;++j) {      // minus one perfect square number
                pre=i-j*j;
                if (dp[pre]+1<min) min=dp[pre]+1;
            }
            dp[i]=min;
        }
        return dp[n];
    }
    
}
