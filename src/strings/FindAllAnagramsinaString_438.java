package strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/
public class FindAllAnagramsinaString_438 {
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res= new ArrayList<>();
        if (s==null || s.length()<1) return res;
        if (p==null || p.length()<1) {
            for (int i=0;i<s.length();++i) res.add(i);
            return res;
        } 
        
        int[] map =new int[26];
        for (char c:p.toCharArray()) ++map[c-'a'];
        char[] cs=s.toCharArray();        
        int start=0,end=0, toMatch=p.length();
        
        while (end<cs.length) {
            if (map[cs[end]-'a']>0) {                
                --toMatch;
            }            
            --map[cs[end]-'a'];                  // char not in p will decrease below 0
            ++end;                               // order here, edit map first, then move pointer
            if (toMatch==0) res.add(start);
            if (end-start==p.length()) {
                if (map[cs[start]-'a']>=0) {     // char in p will decrease to 0 at most               
                    ++toMatch;
                }
                ++map[cs[start]-'a'];
                ++start;                                
            }
        }        
        
        return res;
    }

}
