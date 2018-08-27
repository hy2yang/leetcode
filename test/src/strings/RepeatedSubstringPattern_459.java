package strings;


/*
Given a non-empty string check if it can be constructed by 
taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/
public class RepeatedSubstringPattern_459 {
    
    public boolean repeatedSubstringPattern(String s) {
        if (s==null || s.equals("")) return true;
        if (s.length()==1) return false;
        
        for (int len=s.length()/2;len>1;--len) {
            if (s.length()%len!=0) continue;
            for (int mid=len;mid+len<=s.length();mid+=len) {                
                if (!s.substring(mid-len,mid).equals( s.substring(mid,mid+len) )) break;
                if (mid+len==s.length()) return true;
            }
        }
        
        char[] cs=s.toCharArray();
        for (char c:cs) if (c!=cs[0]) return false;        
        return true;  
    }

}
