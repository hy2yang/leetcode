package onehundred;

public class PalindromePartitioning2 {
    
    public int minCut(String s) {
        char[] c=s.toCharArray();
        int n=c.length;
        boolean[][] isP=new boolean[n][n];
        int[] dp=new int[n];
        // dp[i] is the minimum of i(all seperate chars) and dp[j - 1] + 1 (j <= i), if [j, i] is palindrome.
        // If [j, i] is palindrome, [j + 1, i - 1] is palindrome, and c[j] == c[i].
        for (int i=0;i<n;++i) {
            int min=i;           // front part to i (inclusive) needs at most i cuts
            for (int j=0;j<=i;++j) {
                if (c[j]==c[i] && (i-j<=1 || isP[j+1][i-1])) {
                    isP[j][i]=true;
                    if (j==0) min=0;
                    else {
                        if (dp[j-1]+1<min) min=dp[j-1]+1;
                    }  
                }
            }
            dp[i]=min;
        }
        return dp[n-1];
    }

}
