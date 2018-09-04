package linkedList;
/*
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
public class AddTwoNumbers_2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dh=new ListNode(-1);
        ListNode cur=dh;
        while (l1!=null || l2!=null || carry!=0){
            if (l1!=null) {
                carry+=l1.val;
                l1=l1.next;
            }
            if (l2!=null) {
                carry+=l2.val;
                l2=l2.next;
            }
            cur.next=new ListNode(carry%10);
            carry/=10;  
            cur=cur.next;
        }        
        return dh.next;
    }

}