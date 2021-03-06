package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/*
You are given two non-empty linked lists representing two non-negative integers. 
The most significant digit comes first and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/
public class AddtwoNumbersII_445 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> s1= new ArrayDeque<>();
        Deque<Integer> s2= new ArrayDeque<>();
        
        while (l1!=null){
            s1.push(l1.val);
            l1=l1.next;
        }
        
        while (l2!=null){
            s2.push(l2.val);
            l2=l2.next;
        }
        
        ListNode cur=new ListNode(0);
        ListNode p=cur;
        int sum=0;
        while (!s1.isEmpty() || !s2.isEmpty() || sum!=0){
            cur=p;
            if (!s1.isEmpty()) sum+=s1.pop();
            if (!s2.isEmpty()) sum+=s2.pop();
            cur.val= sum%10;
            sum/=10;
            p=new ListNode(0);
            p.next=cur;            
        }
        return cur;        
    }

}
