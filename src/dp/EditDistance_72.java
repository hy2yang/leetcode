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
    
    /*We define the state dp[i][j] to be the minimum number of operations to convert word1[0..i - 1] to word2[0..j - 1]. 
    The state equations have two cases: the boundary case and the general case. 
    Note that in the above notations, both i and j take values starting from 1.

    For the boundary case: to convert a string to an empty string, 
    the mininum number of operations to convert word1[0..i - 1] to "" requires at least i operations (deletions).
    dp[i][0] = i;
    dp[0][j] = j.
            
    The general case: convert a non-empty word1[0..i - 1] to another non-empty word2[0..j - 1].  
    let's consider word[i - 1] and word2[j - 1]. 
    If they are euqal, then no more operation is needed and dp[i][j] = dp[i - 1][j - 1].
    
    If they are not equal, we need to consider three cases:

    Replace word1[i - 1] by word2[j - 1] (dp[i][j] = dp[i - 1][j - 1] + 1 (for replacement));
    Delete word1[i - 1] and word1[0..i - 2] = word2[0..j - 1] (dp[i][j] = dp[i - 1][j] + 1 (for deletion));
    Insert word2[j - 1] to word1[0..i - 1] and word1[0..i - 1] + word2[j - 1] = word2[0..j - 1] (dp[i][j] = dp[i][j - 1] + 1 (for insertion)).
    For deletion,  convert word1[0..i - 2] to word2[0..j - 1], which costs dp[i - 1][j], and then deleting the word1[i - 1], which costs 1. 
    The case is similar for insertion.*/

}
