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
                if (cs[i]!=cs[j]) continue;
                dp[i][j] =  j-i==1 || dp[i+1][j-1] ;
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }

    public int countSubstrings2(String s) {   // even dp have time complexity O(n^2)
        int res=0;                            // so this "brute" method won't be slower
        char[] cs = s.toCharArray();          // it might be faster due to early termination on impossible chars
        for(int i=0;i<s.length();i++){
            res += extend(cs,i,i);//odd length
            res += extend(cs,i,i+1);//even length
        }
        return res;
    }

    private int extend(char[] cs, int left, int right){
        int count=0;
        while( left>=0 && right<cs.length && cs[left]==cs[right] ){
            --left;
            ++right;
            ++count;
        }
        return count;
    }
    
}
