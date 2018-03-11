package linkedList;
/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/
public class RemoveNthNodeFromEndofList_19 {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next==null) return null;
        ListNode dhead=new ListNode(0);
        dhead.next=head;
        ListNode lo = dhead, hi = dhead;        
        for (int i=0;i<n;i++) {            
            hi=hi.next;
        }        
        while (hi.next!=null) {
            hi=hi.next;
            lo=lo.next;
        }
        lo.next=lo.next.next;
        return dhead.next;
    }

}
