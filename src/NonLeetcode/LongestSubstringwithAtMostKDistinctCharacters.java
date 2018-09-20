package NonLeetcode;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring T that contains at most k distinct characters.
Example
For example, Given s = "eceba", k = 3,
T is "eceb" which its length is 4.

Challenge
O(n), n is the size of the string s.
 */
public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k<1) return 0;
        int[] num = new int[256];
        Set<Character> set = new HashSet<>();
        char[] cs = s.toCharArray();
        int max = 0, lo = 0, hi = 0;
        while (hi<cs.length){
            while (hi<cs.length && set.size()<=k){
                if (set.size()==k && !set.contains(cs[hi])) break;
                set.add(cs[hi]);
                ++num[cs[hi]];
                ++hi;
            }
            if(hi-lo>max) max=hi-lo;
            while (lo<hi && set.size()==k){
                --num[cs[lo]];
                if (num[cs[lo]]==0){
                    set.remove(cs[lo]);
                }
                ++lo;
            }
            if (cs.length-1-lo<=max) break;
        }
        return max;
    }
}
