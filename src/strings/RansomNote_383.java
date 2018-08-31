package strings;
/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
public class RansomNote_383 {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length()<ransomNote.length()) return false;
        int[] map =new int[26];
        
        for (int i=0;i<magazine.length();++i) {
            ++map[magazine.charAt(i)-'a'];
        }
        int pos;
        for (int i=0;i<ransomNote.length();++i) {
            pos=ransomNote.charAt(i)-'a';
            if (map[pos]==0) return false;
            --map[pos];
        }
        return true;
    }

}
