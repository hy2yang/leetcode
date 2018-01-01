package dp;
/*
Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".

Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

public class LongestPalindromicSubsequence_516 {

    public int longestPalindromeSubseq(String s) {
        int[][] dp=new int[s.length()][s.length()];   // dp[i][j]: length of longest palindromic subsequence in substring(i,j). both inclusive
        char[] cs=s.toCharArray(); 
        // if cs[i]==cs[j], dp[i][j]=dp[i+1][j-1]+2
        // else, dp[i][j]=max(dp[i+i][j],dp[i][j-1])
        // dp[i][j] depends on dp[i+1][j-1], dp[i+1][j], dp[i][j-1], so decrease i, increse j
        
        for (int i=dp.length-1;i>=0;--i)  {
            dp[i][i]=1;
            for (int j=i+1;j<s.length();++j) {
                if (cs[i]==cs[j]) dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
        
    }
    
}
