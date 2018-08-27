package linkedList;

import java.util.ArrayDeque;

//Given a singly linked list, determine if it is a palindrome.
//Follow up: do it in O(n) time and O(1) space?

public class PalindromeLinkedList_234 {
    
    public static boolean isPalindrome(ListNode head) {
        
        ListNode slow=head,fast=head,pre=null,temp;
        while (fast!=null && fast.next!=null) {             // find mid and reverse first half
            fast=fast.next.next;
            temp=slow;
            slow=slow.next;
            temp.next=pre;
            pre=temp;
        }
        ListNode mid=slow;
        if (fast!=null) slow=slow.next;
        
        boolean res=true;
        while (pre!=null && slow!=null) {                 // check if reversed first half equals second, and reverse back
            if (res) res=(pre.val==slow.val);
            slow=slow.next;
            temp=pre;
            pre=pre.next;
            temp.next=mid;
            mid=temp;
        }
        return res;
    }
    
    public static boolean isPalindrome2(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode dhead=new ListNode(-1);
        dhead.next=head;
        ListNode slow=dhead,fast=dhead;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;            
            slow=slow.next;
            stack.push(slow.val);
        }
        if (fast==null) stack.pop();
        slow=slow.next;
        while (slow!=null){
            if (slow.val!=stack.peek()) return false;
            stack.pop();
            slow=slow.next;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ListNode p=new ListNode(1);
        p.next=new ListNode(0);
        p.next.next=new ListNode(0);
        //p.next.next.next=new ListNode(2);
        //p.next.next.next.next=new ListNode(1);
        System.out.println(isPalindrome(p));
        System.out.println(p);
    }

}
