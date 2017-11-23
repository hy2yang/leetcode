package strings;
/*
iven two strings s and t, write a function to determine if t is an anagram of s.
For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:You may assume the string contains only lowercase alphabets.
Follow up:What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/
public class ValidAnagram_242 {   
    
    public boolean isAnagram(String s, String t) {
        char[] a=s.toCharArray();
        char[] b=t.toCharArray();
        if(a.length!=b.length) return false;
        int[] map = new int['z'-'a'+1];
        for (int i=0;i<a.length;++i) {
            ++map[a[i]-'a'];
            --map[b[i]-'a'];
        }
        for (int i=0;i<map.length;++i) {
            if (map[i]!=0) return false;
        }
        return true;
    }
    // for follow-up, use int[256]
}
