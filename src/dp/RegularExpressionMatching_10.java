package dp;

import java.util.Arrays;

/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
public class RegularExpressionMatching_10 {
    
    public static void main(String[] args) {
        System.out.println(isMatch("aa","a"));
    }    
    
    public static boolean isMatch(String s, String p) {
        // dp[i][j]: s[0,i) matches p[0,j)
        // if (s[i-1]==p[j-1] || p[j-1]=='.'): dp[i][j]=dp[i-1][j-1]
        // if p[j-1]=='*' 
        //      if s[i-1] can't match p[j-2], dp[i][j]= dp[i][j-2]  (b can match ba*)
        //      else (can match ) dp[i][j]= dp[i-1][j] || dp[i][j-1] || dp[i][j-2]
        //                                 aaa match a*    a match a*   b match a*  
        //                               * means several   * means x1   * means x0 
        // to update d[i][j], need d[i-1][j],d[i-1][j-1], d[i][j-1], dp[i][j-2]  
        
        boolean[] dp=new boolean[p.length()+1];        
        boolean[] pre=new boolean[p.length()+1];
        
        dp[0]=true;  //base
        for (int j = 2; j <dp.length; j+=2) {           // when i==0 (empty string), odd numbers of characters can not match
            dp[j]= p.charAt(j - 1) == '*' && dp[j-2];            
        }
        
        for (int i=1;i<=s.length();++i) { 
            pre=Arrays.copyOf(dp, dp.length);  //last row 
            dp[0]=false;
            for (int j=1;j<=p.length();++j) { 
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[j] = pre[j - 1];
                    continue;
                }
                if (p.charAt(j - 1) == '*') {
                    if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                        dp[j] = dp[j - 2];
                    } 
                    else {
                        dp[j] = pre[j] || dp[j - 1] || dp[j - 2];
                    }
                    continue;
                } 
                else dp[j]=false;
            }            
        }
        return dp[p.length()];
    }    
}


