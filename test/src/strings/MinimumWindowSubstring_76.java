package strings;
/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

If there is no such window in S that covers all characters in T, return the empty string "".
If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

public class MinimumWindowSubstring_76 {
    
    public String minWindow(String s, String t) {
        int[] map=new int[256];
        for (char c:t.toCharArray()) map[c]++;        
        int lo=0,hi=0,minStart=0,found=0,minlen=Integer.MAX_VALUE;
        
        while(hi<s.length()) {
            char c1=s.charAt(hi);
            if (map[c1]>0) ++found;
            --map[c1];
            ++hi;
            while (found==t.length()) {
                if (hi-lo<minlen) {
                    minlen=hi-lo;
                    minStart=lo;
                }
                char c2=s.charAt(lo);
                ++map[c2];     
                if(map[c2]>0) {
                    --found;
                }
                ++lo;
            }
        }
        return (minlen==Integer.MAX_VALUE)? "":s.substring(minStart, minStart+minlen);
    }

}
