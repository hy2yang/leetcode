package strings;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; 
No extra white spaces, square brackets are well-formed, etc.
Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there won't be input like 3a or 2[4].

Examples:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public class DecodeString_394 {
    
    public String decodeString(String s) {
        if (s==null || s=="") return s;
        StringBuilder sb=new StringBuilder();
        Deque<StringBuilder> piece=new ArrayDeque<>();
        Deque<Integer> num=new ArrayDeque<>();
        int count=0;
        for (char c:s.toCharArray()) { 
            
            if (Character.isDigit(c)) count=10*count+c-'0';
            
            else if (c=='[') {
                num.push(count);
                count=0;
                piece.push(sb);
                sb=new StringBuilder();
            }
            
            else if (c==']') {
                StringBuilder temp=sb;
                sb=piece.pop();
                for (int repeat=num.pop();repeat>0;--repeat) sb.append(temp); 
            }
            
            else sb.append(c);
        }
        return sb.toString();
    }

}
