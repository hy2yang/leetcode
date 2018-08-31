package dp;

public class DungeonGame_147 {
    
    public int calculateMinimumHP(int[][] d) {
        //Dp state equation:
        //dp[i][j] minimum health level required to reach the bottom-right when entering (i, j) 
        //Dp State Transition Equation:
        //Dp[i][j] = max(1,min(dp[i+1][j],dp[i][j+1]) - grid[i][j]);
        
        int x=d.length,y=d[0].length;
        int[] dp=new int[y]; 
        
        dp[y-1]=d[x-1][y-1]>0? 1:1-d[x-1][y-1];      // pricess room
        
        for (int j=y-2;j>=0;--j) {                   // last row
            dp[j]=Math.max(1, dp[j+1]-d[x-1][j]);
        }
        
        for (int i=x-2;i>=0;--i) {  
            dp[y-1]=Math.max(1, dp[y-1]-d[i][y-1]);  // last column
            for (int j=y-2;j>=0;--j) {
                dp[j]=Math.max(1, Math.min(dp[j], dp[j+1])-d[i][j]);
            }
        }
        return dp[0];
    }

}
