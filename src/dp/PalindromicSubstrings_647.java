package dp;
/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:
The input string length won't exceed 1000.
*/
public class PalindromicSubstrings_647 {

    public int countSubstrings(String s) {
        int res=0;
        if (s==null || s.length()<1) return res;        
        char[] cs=s.toCharArray();
        int len=cs.length;
        boolean[][] dp= new boolean[len][len];  // dp[i][j] if substring(i,j) both inclusive, is palindromic
        
        for (int i=len-1;i>=0;--i) {            // i:start, decrease; j:end, increase;
            dp[i][i]=true;
            ++res;
            for (int j=i+1;j<len;++j) {
                dp[i][j] = cs[j]==cs[i] && ( j-i==1 || dp[i+1][j-1] );
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }
    
}
