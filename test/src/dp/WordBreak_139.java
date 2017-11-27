package dp;

import java.util.List;

/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
You may assume the dictionary does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].
Return true because "leetcode" can be segmented as "leet code".
*/

public class WordBreak_139 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int len=s.length();
        boolean[] startHere=new boolean[len+1];
        startHere[0]=true;
        for (int i=0;i<len+1;++i) {        //  start
            if (startHere[i]) {
                for (int j=i+1;j<len+1;++j) {    // end
                    if (wordDict.contains(s.substring(i, j))) startHere[j]=true;
                }
            }            
        }
        return startHere[len];         // len can be start <-> 0~len-1 part can be broken into dict words
    }

}
