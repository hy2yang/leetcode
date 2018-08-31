package general;
/*
design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

import java.util.ArrayDeque;

public class MinStack_155 {
    
    private ArrayDeque<X> s;   // can be faster if use link list (node with value and minSoFar)
    
    class X{
        private int val,minSoFar;
        public int getVal() {
            return val;
        }
        public int getMinSoFar() {
            return minSoFar;
        }
        public X(int val, int min) {
            this.val=val;
            this.minSoFar=min;
        }
    }
    
    public MinStack_155() {
        this.s=new ArrayDeque<X>();
    }
    
    public void push(int x) {
        int min;
        if (s.size()==0) min=x;
        else min=Math.min(x, getMin());
        s.push(new X(x, min));
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {        
        return s.peek().minSoFar;
    }

}
