package strings;
/*
Given a string that consists of only uppercase English letters, 
you can replace any letter in the string with another letter at most k times. 
Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:
Input:
s = "ABAB", k = 2
Output:
4
Explanation:
Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input:
s = "AABABBA", k = 1
Output:4
Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

public class LongestRepeatingCharacterReplacement_424 {
    
    public int characterReplacement(String s, int k) {
        int[] map=new int[26];
        char[] cs=s.toCharArray();
        int start=0, end=0, res=0, common=0, temp;
        while ( end<s.length() ) {
            temp=++map[cs[end]-'A'];
            if (temp>common) common=temp;
            while (end-start+1-common>k) {    // chars other than the most common one can not exceed k 
                --map[cs[start]-'A'];
                ++start;
            }
            res= Math.max(res, end-start+1);
            ++end;
        }
        return res;
    }

}
