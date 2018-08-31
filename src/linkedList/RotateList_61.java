package linkedList;

//Given a list, rotate the list to the right by k places, where k is non-negative.

public class RotateList_61 {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null) return head;
        ListNode cur=head;
        int len=0;
        while (cur!=null) {
            cur=cur.next;
            ++len;
        }
        k%=len;
        cur=head;
        ListNode pre=head;
        for (int i=0;i<k;++i) {
            cur=cur.next;
        }
        while (cur.next!=null) {
            cur=cur.next;
            pre=pre.next;
        }
        cur.next=head;
        ListNode newhead=pre.next;
        pre.next=null;
        return newhead;
    }

}
