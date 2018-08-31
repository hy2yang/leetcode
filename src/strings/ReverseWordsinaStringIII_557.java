package strings;
/*
Given a string, you need to reverse the order of characters in each word within a sentence 
while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
*/

public class ReverseWordsinaStringIII_557 {
    
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (char i: s.toCharArray()){
            if (i==' '){
                res.append(word.reverse());
                res.append(' ');
                word=new StringBuilder();
            }
            else word.append(i);
        }
        res.append(word.reverse());
        return res.toString();
    }

}
