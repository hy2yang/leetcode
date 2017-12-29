package arrays;
/*
Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. 
t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of 
the characters without disturbing the relative positions of the remaining characters. 
(ie, "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
s = "abc", t = "ahbgdc"
Return true.

Example 2:
s = "axc", t = "ahbgdc"
Return false.

Follow up:
If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, 
and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
*/
public class IsSubsequence_392 {
    
    public boolean isSubsequence(String s, String t) {
        if (s==null || s.length()<1) return true;
        char[] arr_s=s.toCharArray(), arr_t=t.toCharArray();
        int posS=0,posT=0;
        while (posT<arr_t.length) {
            if (arr_s[posS]==arr_t[posT]) {
                ++posS;
                if (posS==arr_s.length) return true;
            }            
            ++posT;
        }
        return false;
    }
    
    // for follow-up: record the indexes for each character in t in sequence, 
    // if s[i] matches t[j], then s[i+1] should match t[x] where x>j. 
    // which is find ceiling, can be achieved using binary search.
    
    
    public boolean isSubsequence_dp(String s, String t) {  // DP is overkill for this problem, slow and memory-consuming
        if (s==null || s.length()<1) return true;
        if (t==null || t.length()<1) return false;
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        
        for (int i=1;i<=t.length();++i) {
            dp[0]=true;
            boolean upleft=true,temp;
            for (int j=1;j<=s.length();++j) {
                if (j>i) break;
                temp=dp[j];
                if (t.charAt(i-1)==s.charAt(j-1)) dp[j]=upleft;                
                if (j==s.length() && dp[j]) return true;
                upleft=temp;
            }
        }
        return false;
    }

    public boolean isSubsequence_2Ddp(String s, String t) {
        if (s==null || s.length()<1) return true;
        if (t==null || t.length()<1) return false;
        boolean[][] dp=new boolean[t.length()+1][s.length()+1];
        dp[0][0]=true;
        
        for (int i=1;i<=t.length();++i) {
            dp[i][0]=true;
            
            for (int j=1;j<=s.length();++j) {
                if (j>i) break;
                if (t.charAt(i-1)==s.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=dp[i-1][j];
                
                if(j==s.length() && dp[i][j]) return true;
            }
        }
        return false;
    }
    
    
}
