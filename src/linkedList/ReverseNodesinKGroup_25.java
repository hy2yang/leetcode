package linkedList;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. 
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.
For example,
Given this linked list: 1->2->3->4->5 
For k = 2, you should return: 2->1->4->3->5 
For k = 3, you should return: 3->2->1->4->5 
*/
public class ReverseNodesinKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null) return head;
        ListNode dHead=new ListNode(-1);
        dHead.next=head;
        ListNode pre=dHead, tail=dHead;

        while (true){
            for (int i=0;i<k;++i){
                tail=tail.next;
                if (tail==null) return dHead.next;
            }
            ListNode newPre = pre.next;
            reverseBetween(pre, tail);
            pre = newPre;
            tail =pre;
        }
    }

    private void reverseBetween(ListNode dHead, ListNode tail){
        ListNode cur = dHead.next;
        ListNode temp = cur.next;
        ListNode end = tail.next;
        while (temp!=end) {
            cur.next = temp.next;
            temp.next=dHead.next;
            dHead.next=temp;
            temp=cur.next;
        }
    }

}
