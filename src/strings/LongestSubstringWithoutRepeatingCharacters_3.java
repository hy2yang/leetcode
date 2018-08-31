package strings;
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        int res=0;
        char[] cs=s.toCharArray();
        int[] map =new int[128];
        int lo=0,hi=0;
        while (lo<cs.length) {
            while (hi<cs.length && map[cs[hi]]==0) {
                ++map[cs[hi++]];
            }
            if (hi-lo>res) res=hi-lo;
            --map[cs[lo++]];
        }
        return res;
    }
    
}
