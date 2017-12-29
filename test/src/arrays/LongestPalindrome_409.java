package arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given a string which consists of lowercase or uppercase letters, 
find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"
Output:
7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/
public class LongestPalindrome_409 {
    
    public int longestPalindrome(String s) {
        int res=0;
        int[] set=new int[128];
        for (char i:s.toCharArray()) {
            if (set[i]>0) {
                res+=2;
                --set[i];
            }
            else ++set[i];
        }
        if (res<s.length()) ++res;      // some char left, choose any one to put in center
        return res;
    }
    
    public int longestPalindrome_set(String s) {
        int res=0;
        Set<Character> set=new HashSet<>();
        for (char i:s.toCharArray()) {
            if (set.contains(i)) {
                res+=2;
                set.remove(i);
            }
            else set.add(i);
        }
        if (set.size()!=0) ++res;
        return res;
    }

}
