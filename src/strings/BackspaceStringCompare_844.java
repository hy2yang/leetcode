package strings;

/*
Given two strings S and T, return if they are equal when both are typed into empty text editors.
# means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.

Follow up:
Can you solve it in O(N) time and O(1) space?
 */

public class BackspaceStringCompare_844 {

    public boolean backspaceCompare(String S, String T) {  // for strict O(1) space, use String.charAt()
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int ps = s.length-1, pt = t.length-1, count;
        while (true){
            count = 0;
            while (ps>=0 && (count>0 || s[ps]=='#') ){
                count += s[ps]=='#'? 1:-1;
                --ps;
            }
            count = 0;
            while (pt>=0 && (count>0 || t[pt]=='#') ){
                count += t[pt]=='#'? 1:-1;
                --pt;
            }

            if (ps<0 && pt<0) return true;
            if (ps<0 || pt<0 || s[ps]!=t[pt]) return false;
            --ps;
            --pt;
        }
    }
}
