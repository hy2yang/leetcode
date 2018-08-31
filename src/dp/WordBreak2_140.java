package dp;
/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
add spaces in s to construct a sentence where each word is a valid dictionary word. 
You may assume the dictionary does not contain duplicate words.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].
A solution is ["cats and dog", "cat sand dog"].
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class WordBreak2_140 {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<Integer, List<String>> dp = new HashMap<>(); // stores valid breaks after each position i
        int maxlen = 0;
        Set<String> wordSet = new HashSet<>();
        for(String temp : wordDict) {   
            wordSet.add(temp);
            if (temp.length()>maxlen) maxlen=temp.length();
        }
        return addSpaces(s, wordSet, 0, maxlen, dp);
    }

    private List<String> addSpaces(String s, Set<String> wordDict, int start, int maxlen, Map<Integer, List<String>> dp) {
        List<String> words = new ArrayList<>();
        if (start == s.length()) {
            words.add("");
            return words;
        }
        for (int j = start + 1;j <= s.length(); ++j) {
            if ( j > maxlen + start ) break;
            if (wordDict.contains(s.substring(start, j))) {
                List<String> back;
                if (dp.containsKey(j)) back = dp.get(j);
                else back = addSpaces(s, wordDict, j, maxlen, dp);
                for (String temp : back)
                    words.add(s.substring(start, j) + (temp.equals("")? "":" ") + temp);
            }

        }
        dp.put(start, words);
        return words;
    }
    
    /*
    class Solution {
    
        public static List<String> wordBreak(String s, List<String> wordDict) {
            if (wordDict.size() == 0)
                return new ArrayList<>();
            return helper(s, wordDict, 0);
        }

        private static boolean canBreak(String s, List<String> wordDict) {
            int len = s.length();
            boolean[] startHere = new boolean[len + 1];
            startHere[0] = true;
            for (int i = 0; i < len + 1; ++i) { // start
                if (startHere[i]) {
                    for (int j = i + 1; j < len + 1; ++j) { // end
                        if (wordDict.contains(s.substring(i, j)))
                            startHere[j] = true;
                    }
                }
            }
            return startHere[len]; // len can be start <-> 0~len-1 part can be broken into dict words
        }

        private static ArrayList<String> helper(String s, List<String> wordDict, int start) {
            ArrayList<String> res = new ArrayList<>();
            if (!canBreak(s.substring(start), wordDict))
                return res;
            if (start == s.length()) {
                res.add("");
                return res;
            }

            String space;
            for (int j = start + 1; j <= s.length(); ++j) {
                if (wordDict.contains(s.substring(start, j))) {
                    for (String temp : helper(s, wordDict, j)) {
                        space = temp.length() < 1 ? "" : " ";
                        res.add(s.substring(start, j) + space + temp);
                    }
                }
            }
            return res;
        }
        
        public static void main(String[] args) {
            List<String> wordDict=new ArrayList<>();
            wordDict.add("cat");
            wordDict.add("cats");
            wordDict.add("and");
            wordDict.add("sand");
            wordDict.add("dog");
            String s="catsanddog";
            System.out.println(wordBreak(s,wordDict));
        }
    }
    */
}
