package dp;
/*
Given a string S and a string T, count the number of distinct sequences of T in S.
A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"
Return 3.
*/

public class DistinctSubsequences_115 {
    
    public int numDistinct(String s, String t) {
        int x=t.length(), y=s.length();
        int[][] dp=new int[x+1][y+1];   // dp[i][j]: number of subsequences of (first i char in T) in (first j char in S) 
        
        for(int j=0;j<y;++j) {  // empty string is a subsequence of any string for only 1 time (remove all char)
            dp[0][j]=1;
        }
        
    //case 1). if T[i] != S[j], then the solution would be to ignore the character S[j] and align substring T[0..i] with S[0..(j-1)]. 
    //Therefore, dp[i][j] = dp[i][j-1].
    //case 2). if T[i] == S[j], then first part is the solution in case 1), but also we could match the characters T[i] and S[j] 
    //and align the rest (i.e. T[0..(i-1)] and S[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + d[i-1][j-1]
        for (int i=0;i<x;++i) {
            //dp[i+1][0]=0;        // empty string can't contain any non-empty string, initialized as 0
            for (int j=0;j<y;++j) {
                if (t.charAt(i)!=s.charAt(j)) dp[i+1][j+1]=dp[i+1][j];     // i from 0 to length, charAt(0) is first, letter index=1 
                else dp[i+1][j+1]=dp[i+1][j]+dp[i][j];               
            }
        }
        return dp[x][y];
    }
    
    public int numDistinct2(String s, String t) {         // reduce to 1-D
        int x=t.length(), y=s.length();
        int[] dp=new int[y+1];   // dp[i][j]: number of subsequences of (first i char in T) in (first j char in S) 
        
        for(int j=0;j<y;++j) {  // empty string is a subsequence of any string for only 1 time (remove all char)
            dp[j]=1;
        }
        
        int upleft;
        for (int i=0;i<x;++i) {
            upleft=dp[0];
            dp[0]=0;        // empty string can't contain any non-empty string
            for (int j=0;j<y;++j) {
                int temp=dp[j+1];
                if (t.charAt(i)!=s.charAt(j)) dp[j+1]=dp[j];     // i from 0 to length, charAt(0) is first, letter index=1 
                else dp[j+1]=dp[j]+upleft;
                upleft=temp;
            }
        }
        return dp[y];
    }

}
