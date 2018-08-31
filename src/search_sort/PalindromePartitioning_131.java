package search_sort;

import java.util.ArrayList;
import java.util.List;

/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
*/
public class PalindromePartitioning_131 {
    
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        if (s.length()<1) return res;
        helper(s.toCharArray(), 0, res, new ArrayList<>());
        return res;
    }
    
    private void helper(char[] s, int start, List<List<String>> res, ArrayList<String> wip) {
        if (start==s.length) {
            res.add(new ArrayList<String>(wip));
            return;
        }
        for (int end=start+1; end<=s.length ;++end) {
            if (validate(s, start, end-1)) {
                wip.add(new String(s, start, end-start));
                helper(s, end ,res,wip);
                wip.remove(wip.size()-1);
            }
        }        
    }
    
    private boolean validate(char[] s, int from, int to) {
        if (to-from<1) return true;
        int lo=from, hi=to;
        while (lo<hi){
            if (s[lo]!=s[hi]) return false;
            ++lo;--hi;
        }
        return true;
    }
 
}
