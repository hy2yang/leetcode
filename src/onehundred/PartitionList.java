package onehundred;

public class PartitionList {
    
    public ListNode partition(ListNode head, int x) {
        if (head==null || head.next==null) return head;
        ListNode front= new ListNode(0);
        ListNode back= new ListNode(0);
        ListNode p=head;
        ListNode f=front;
        ListNode b=back;
        
        
        while (p!=null) {
            if (p.val<x) {
                f.next=p;
                f=f.next;
            }
            else {
                b.next=p;
                b=b.next;
            }
            p=p.next;
        }
        b.next=null;
        f.next=back.next;        
        return front.next; 
    }

}
