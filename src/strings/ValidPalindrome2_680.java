package strings;
/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/
public class ValidPalindrome2_680 {
    
    public boolean validPalindrome(String s) {
        int lo=0,hi=s.length()-1;
        while (lo<hi) {
            if(s.charAt(lo)!=s.charAt(hi)) break;
            ++lo;
            --hi;
        }
        if (lo>=hi) return true;
        else return isPalindrome(s, lo+1, hi)||isPalindrome(s, lo, hi-1);
    }
    
    private boolean isPalindrome(String s, int lo, int hi) {
        while(lo<hi) {
            if(s.charAt(lo)!=s.charAt(hi)) return false;
            ++lo;
            --hi;
        }
        return true;
    }

}
