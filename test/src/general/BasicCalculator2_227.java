package general;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/
public class BasicCalculator2_227 {
    
    public int calculate(String s) {
        if (s==null || s.length()<1) return 0;        
        int num=0, cur=0, res=0;
        int loSign=1, hiSign=0;    // +- is lower priority than */, for hisign *=1,/=-1
        char[] cs=s.toCharArray();
        
        for (int i=0;i<cs.length;++i) {
            if (cs[i]==' ') continue;
            
            if (Character.isDigit(cs[i])) {
                num=cs[i]-'0';
                while (i+1<cs.length && Character.isDigit(cs[i+1]) ){  //move i to last digit, don't move over to cause omitting
                    num=num*10+cs[++i]-'0';     // ++i not i++, next digit, not current;                       
                }  
                if (hiSign==0) cur=num;
                else cur= hiSign>0? cur*num:cur/num;                
            }
            else if (cs[i]=='*' || cs[i]=='/') {
                hiSign= cs[i]=='*'? 1:-1;
                num=0;
            }
            
            else if (cs[i]=='+' || cs[i]=='-') {
                res+=loSign*cur;
                loSign= cs[i]=='+'? 1:-1;
                hiSign=0;                       // important, reset hisign
                num=0;
            }      
        }
        return res+loSign*cur;        
    }

}
