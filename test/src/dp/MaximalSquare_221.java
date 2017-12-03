package dp;

/*Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
*/
public class MaximalSquare_221 {
    
    public int maximalSquare(char[][] matrix) {
        if (matrix.length<1 || matrix[0].length<1) return 0;
        int[] dp =new int[matrix[0].length+1];             // dp[i][j] side length of max square ends here
        int upleft=0,max=0,temp;
        for (int i=0;i<matrix.length;++i) {
            for (int j=1;j<=matrix[0].length;++j) {
                temp=dp[j];
                if (matrix[i][j-1]=='0') {
                    dp[j]=0;
                }
                else {                    
                    dp[j]= Math.min(dp[j], Math.min(dp[j-1], upleft))+1;
                    if (dp[j]>max) max=dp[j];
                }
                upleft=temp;
            }
        }
        return max*max;
    }

}
