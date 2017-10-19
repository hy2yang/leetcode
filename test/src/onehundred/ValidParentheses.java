package onehundred;
import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    static boolean isValid(String s) {
        if (s.length()==0) return true;
        if (s.length()%2==1) return false;
        String left="([{";
        String right=")]}";
        Stack<Character> a =new Stack<>();
        for (char c: s.toCharArray()) {
            if ( right.indexOf(c)>-1) {
                if (a.isEmpty()) return false;
                if (right.indexOf(c)!=left.indexOf(a.peek())) return false;
                a.pop();
                continue;
            }
            else {
                a.push(c);
            }
                
        }
        if (a.isEmpty()) return true;
        else return false;
    }

}
