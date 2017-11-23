package strings;
/*
Given two strings s and t, determine if they are isomorphic.
Two strings are isomorphic if the characters in s can be replaced to get t.
All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character but a character may map to itself.
You may assume both s and t have the same length.
For example,
Given "egg", "add", return true.
Given "foo", "bar", return false.
Given "paper", "title", return true.
*/

import java.util.HashMap;

public class IsomorphicStrings_205 {
    
    public boolean isIsomorphic(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        HashMap<Character, Character> m =new HashMap<>();
        for (int i=0;i<a.length;++i) {
            if (m.containsKey(a[i]) && m.get(a[i])!=b[i]) return false;
            if (!m.containsKey(a[i]) && m.containsValue(b[i])) return false;
            m.put(a[i], b[i]);
        }
        return true;
    }
    
    public boolean isIsomorphic_noMap(String s, String t) {  // since all chars are in ASCII table, we can use an int array as "map"
        char[] a=s.toCharArray();
        char[] b=t.toCharArray(); 
        
        int[] m1=new int[256], m2=new int[256];   // ascii size=256
        for (int i=0;i<a.length;++i) {
            if (m1[a[i]]!=m2[b[i]]) return false;
            m1[a[i]]=i+1;
            m2[b[i]]=i+1;
        }
        return true;
    }
    
    
}
