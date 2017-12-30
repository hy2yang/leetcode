package strings;
/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) 
such that every character in T appears no less than k times.

Example 1:
Input:
s = "aaabb", k = 3
Output:
3
The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
Input:
s = "ababbc", k = 2
Output:
5
The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public class LongestSubstringwithAtLeastKRepeatingCharacters_395 {
    
    public int longestSubstring(String s, int k) {
        if (s==null || s.length()<1) return 0;
        if (k<2) return s.length();
        
        char[] c=s.toCharArray();
        int[] map=new int[26];
        
        for (int i=0;i<c.length;++i) ++map[c[i]-'a'];
        
        boolean qualify=true;
        for (int i=0;i<map.length;++i) {
            if (map[i]>0 && map[i]<k) {
                qualify=false;  // if the whole string qualifies
                break;
            }
        }
        if (qualify) return c.length;
        
        int res=0, start=0, end=0, len;
        while(start<c.length) {
            if (map[c[start]-'a']<k) ++start;       // ignore unqualified chars
            else { 
                end=start+1;
                while(end<c.length && map[c[end]-'a']>=k ) ++end;    // find next unqualified char as end
                len=longestSubstring(s.substring(start, end),k);  // check the mid part between two split positions
                if (len>res) res=len;
                start=end+1;
            }            
        }
        return res; 
    }
    

    public int longestSubstring_rec(String s, int k) {
        if (s==null || s.length()<1) return 0;
        if (k<2) return s.length();
        char[] c=s.toCharArray();
        return helper(c,k,0,c.length);        
    }
    
    private int helper (char[] c, int k, int start, int end) {
        if (end-start<k) return 0;
        int[] map=new int[26];
        
        for (int i=start;i<end;++i) ++map[c[i]-'a'];        
        
        for (int i=0;i<26;++i) {
            if (map[i]>0 && map[i]<k) {   // use this unqualified char as split 
                for (int pos=start;pos<end;++pos) {
                    if (c[pos]==(char)(i+'a')) {
                        return Math.max(helper(c,k,start,pos),helper(c,k,pos+1,end));
                    }
                }
            }
        }        
        return end-start;
    }
    
}
