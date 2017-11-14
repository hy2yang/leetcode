package dp;
/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
each operation is counted as 1 step.
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
*/

public class EditDistance_72 {
    
    // dp[i][j]: shortest edit distance between word1[0,i) and word2[0, j)
    
    public int minDistance(String word1, String word2) {
     int a=word1.length();
     int b=word2.length();
     
     int[] dp=new int[b+1];
     for (int j=0;j<dp.length;++j) {
         dp[j]=j;
     }
     int pre, temp;
     for (int i=1;i<=a;++i) {
         pre=dp[0];             // store to pre
         dp[0]=i;               // update
         for (int j=1;j<=b;++j) {   
             temp=dp[j];           // store the un-updated dp[j] to next pre(to calculate dp[j+1])
             if (word1.charAt(i-1)==word2.charAt(j-1)) {
                 dp[j]=pre;                 
             }
             else dp[j]=1+Math.min(pre, Math.min(dp[j], dp[j-1]));
             pre=temp;
         }
     }
     return dp[b];
    }

}
