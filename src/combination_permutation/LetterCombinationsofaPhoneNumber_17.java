package combination_permutation;

import java.util.ArrayList;
import java.util.List;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
public class LetterCombinationsofaPhoneNumber_17 {

    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();        
        if (digits.length()==0) {
            return res;
        }
        char[] cs=digits.toCharArray();
        
        for (char c:cs) {
            addLetter(res, c-'0');
        }
        return res;
    }
    
    private void addLetter(List<String> res, int cur) {
        String[] map= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int size=res.size();
        if (size==0) {
            for (char c: map[cur].toCharArray()) {
                res.add(Character.toString(c));
            }
        }
        else {            
            for (int i=0;i<size;++i) {
                String s=res.remove(0);
                for (char c: map[cur].toCharArray()) {
                    res.add(s+c);
                }
            }
        }
    }
    
}
