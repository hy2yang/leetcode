package general;
/*
Implement the following operations of a queue using stacks. 
push(x) -- Push element x to the back of queue. 
pop() -- Removes the element from in front of queue. 
peek() -- Get the front element. 
empty() -- Return whether the queue is empty. 
Notes:
You must use only standard operations of a stack -- 
    which means only push to top, peek/pop from top, size, and is empty operations are valid.

You may assume that all operations are valid (for example, 
        no pop or peek operations will be called on an empty queue).
*/

import java.util.ArrayDeque;

public class ImplementQueueusingStacks_232 {
    
    class MyQueue {
        
        private ArrayDeque<Integer> s1;
        private ArrayDeque<Integer> s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1=new ArrayDeque<Integer>();
            s2=new ArrayDeque<Integer>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);            
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            transfer();
            return s2.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            transfer();
            return s2.peek();
        }
        
        private void transfer(){
            if (s2.isEmpty()){
                while (!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty()&&s2.isEmpty();
        }
    }

}
