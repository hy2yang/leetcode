package strings;
/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/
public class FirstUniqueCharacterinaString_387 {

    public int firstUniqChar(String s) {
        if (s==null || s.length()<1) return -1;        
        int[] map=new int[26];
        
        for (char c: s.toCharArray()) {
            ++map[c-'a'];
        }
        
        for (int i=0;i<s.length();++i) {
            if (map[s.charAt(i)-'a']==1) return i; 
        }
        return -1;
    }
    
}
