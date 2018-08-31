package strings;
/*
Given a string, determine if it is a palindrome, 
considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
*/

public class ValidPalindrome_125 {
    
    public static boolean isPalindrome(String s) {
        if (s.length()<2) return true;
        char[] arr=s.toCharArray();
        int lo=0;
        int hi=s.length()-1;
        while (lo<hi) {
            if (!isValid(arr[lo])) {
                ++lo;
                continue;
            }
            if (!isValid(arr[hi])) {
                --hi;
                continue;
            }
            if (arr[lo]>='a') arr[lo]-='a'-'A';
            if (arr[hi]>='a') arr[hi]-='a'-'A';            
            if (arr[lo]!=arr[hi]) return false;
            --hi;
            ++lo;
        }
        return true;
    }
    
    private static boolean isValid(char c) {
        return (c>='0' && c<='9')||(c>='A' && c<='Z')||(c>='a' && c<='z');
    }
    
    public static void main(String[] args) {
        System.out.print(isPalindrome("Aa"));
    }

}
