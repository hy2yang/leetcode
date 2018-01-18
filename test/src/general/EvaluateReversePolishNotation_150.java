package general;

import java.util.ArrayDeque;
import java.util.Deque;

/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/
public class EvaluateReversePolishNotation_150 {

    public int evalRPN(String[] tokens) {
        if (tokens==null || tokens.length<1) return 0;
        Deque<Integer> s = new ArrayDeque<>();
        int x,y;
        for (String cur : tokens) {
            if (cur.equals("+")) {                
                y=s.pop();
                x=s.pop();
                s.push(x+y);
            }
            else if (cur.equals("-")) {
                y=s.pop();
                x=s.pop();
                s.push(x-y);
            }
            else if (cur.equals("*")) {
                y=s.pop();
                x=s.pop();
                s.push(x*y);
            }
            else if (cur.equals("/")) {
                y=s.pop();
                x=s.pop();
                s.push(x/y);
            }
            else s.push(Integer.parseInt(cur));
        }
        return s.pop();
    }
    
}
