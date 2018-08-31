package general;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -,
non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.
*/
public class BasicCalculator_224 {
    
    public int calculate(String s) {
        if (s==null || s.length()<1) return 0;
        Deque<Integer> stack=new ArrayDeque<>();
        int num=0, res=0, sign=1;
        char[] cs=s.toCharArray();
        
        for (int i=0;i<cs.length;++i) {
            if (cs[i]==' ') continue;
            
            if (Character.isDigit(cs[i])) {
                num=cs[i]-'0';
                while (i+1<cs.length && Character.isDigit(cs[i+1]) ){  //move i to last digit, don't move over to cause omitting
                    num=num*10+cs[++i]-'0';     // ++i not i++, next digit, not current;                       
                }
                res+=num*sign;
            }
            else if (cs[i]=='+') sign=1;
            else if (cs[i]=='-') sign=-1;
            else if (cs[i]=='(') {
                stack.push(res);        // store res and sign, reset for new piece
                stack.push(sign);
                res=0;
                sign=1;
            }
            else if (cs[i]==')') {
                res=res*stack.pop()+stack.pop();  // stored in stack, sign on top, piece next
            }            
        }
        return res;        
    }

}
