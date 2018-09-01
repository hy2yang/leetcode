package arrays;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a string S, check if the letters can be rearranged so that
two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:
Input: S = "aab"
Output: "aba"

Example 2:
Input: S = "aaab"
Output: ""

Note:
S will consist of lowercase letters and have length in range [1, 500].
*/
public class ReorganizeString_767 {

    public String reorganizeString(String S) {
        if (S==null || S.length()<1) return "";
        char[] cs = S.toCharArray();
        int[][] freqMap = new int[26][2];    // int[2] arr = {char in int, freq}

        for (char c : cs){
            freqMap[c-'a'][0] = c-'a';
            ++freqMap[c-'a'][1];
        }
        Arrays.sort(freqMap, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p2[1]-p1[1];
            }
        });

        return reorganizable(freqMap, cs.length)? getReorganized(freqMap, cs.length):"";
    }

    private boolean reorganizable(int[][] freqMap, int len){
        int hiFreq = freqMap[0][1];
        return (hiFreq <= freqMap[1][1] || len-hiFreq >= hiFreq-1);
    }

    private String getReorganized(int[][] freqMap, int len){
        char[] cs = new char[len];
        int pMap=0, pCs=0;

        while(pMap<26 && freqMap[pMap][1]>0 ){
            char cur = (char)(freqMap[pMap][0]+'a');
            cs[pCs] = cur;
            pCs+=2;
            if(--freqMap[pMap][1]==0) ++pMap;
            if(pCs>=cs.length) pCs=1;
        }
        return new String(cs);
    }

}
