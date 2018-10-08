package strings;

/*
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

Note:
S.length <= 100
33 <= S[i].ASCIIcode <= 122
S doesn't contain \ or "
 */
public class ReverseOnlyLetters_917 {

    public String reverseOnlyLetters(String S) {
        char[] cs = S.toCharArray();
        int lo = 0;
        int hi = cs.length-1;

        while (lo<hi){
            while (lo<hi && !isLetter(cs[lo])) ++lo;
            while (lo<hi && !isLetter(cs[hi])) --hi;
            if (lo<hi) swap(cs, lo++, hi--);
        }
        return new String(cs);
    }

    private static void swap(char[] cs, int lo, int hi){
        char temp = cs[lo];
        cs[lo] = cs[hi];
        cs[hi] = temp;
    }

    private static boolean isLetter(char c){
        return (c>='a'&& c<='z') || (c>='A' && c<='Z');
    }
}
