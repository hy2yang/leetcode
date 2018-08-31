package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection 
between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
        
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
*/
public class WordPattern_290 {
    
    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];
        String[] strs=str.split(" ");
        if (strs.length!=pattern.length()) return false;
        char[] cs=pattern.toCharArray();
        
        for (int i=0;i<cs.length;++i){
            int index=cs[i]-'a';
            if (map[index]!=null){
                if (!map[index].equals(strs[i])) return false;
            } else {
                map[index] = strs[i];
            }            
        }
        
        Set<String> set= new HashSet<>();
        for (String i : map){
            if (i!=null && !set.add(i)) return false;
        }
        
        return true;
    }
    
    public boolean wordPattern2(String pattern, String str) {
        Map<Character, String> map=new HashMap<>();
        String[] strs=str.split(" ");
        if (strs.length!=pattern.length()) return false;
        char[] cs=pattern.toCharArray();
        
        for (int i=0;i<cs.length;++i){
            if (map.containsKey(cs[i])){
                if (!map.get(cs[i]).equals(strs[i])) return false;
            } else {
                if (map.containsValue(strs[i])) return false;
                map.put(cs[i], strs[i]);
            }            
        }
        return true;
    }
    
}
