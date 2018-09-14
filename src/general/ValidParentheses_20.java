package general;

import java.util.ArrayDeque;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/
public class ValidParentheses_20 {

    public boolean isValid(String s) {
        if (s==null || s.length()<1) return true;
        if ((s.length()&1)!=0) return false;
        char[] cs=s.toCharArray();
        char[] stack = new char[cs.length];
        int p = 0;

        for (char c:cs) {
            if (c=='(') stack[p++]=')';
            else if (c=='[') stack[p++]=']';
            else if (c=='{') stack[p++]='}';
            else if (p==0 || stack[--p]!=c) return false;
        }
        return p==0;
    }

    public boolean isValid_actualStack(String s) {
        if (s==null || s.length()<1) return true;
        if (s.length()%2==1) return false;
        char[] cs=s.toCharArray();
        ArrayDeque<Character> stack=new ArrayDeque<>(); // stack contains right ones to be matched
        
        for (char c:cs) {
            if (c=='(') stack.push(')');
            else if (c=='[') stack.push(']');
            else if (c=='{') stack.push('}');
            else if (stack.isEmpty() || stack.pop()!=c) return false;
        }
        return stack.isEmpty();
    }
    
}
