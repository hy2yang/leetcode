package strings;

import java.util.ArrayList;
import java.util.List;

/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard.
        
Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.
*/
public class KeyboardRow_500 {

    public String[] findWords(String[] words) { 
        List<String> res= new ArrayList<>();
        for ( int i=0;i<words.length;++i ){
            String temp= words[i].toLowerCase();
            if (oneRow(temp)) res.add(words[i]);
        }
        return res.toArray(new String[res.size()]);
    }
    
    private boolean oneRow( String i ){
        String top="[qwertyuiop]+", mid="[asdfghjkl]+", buttom="[zxcvbnm]+";
        return i.matches(top)||i.matches(mid)||i.matches(buttom);
    }
    
    
}
