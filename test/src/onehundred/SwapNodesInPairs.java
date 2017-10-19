package onehundred;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode p=head;
        ListNode h=head.next;
        if (p!=null && p.next!=null) {
            ListNode d=new ListNode(0);
            d.next=p.next;
            p.next=p.next.next;
            d.next.next=p;
        }
        while (p!=null && p.next!=null && p.next.next!=null) {
            ListNode d=new ListNode(0);
            d=p.next;
            p.next=d.next;
            d.next=d.next.next;
            p.next.next=d;
            p=p.next.next;
        }
        return h;
    }
    
    /*
    public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode current = dummy;
    while (current.next != null && current.next.next != null) {
        ListNode first = current.next;
        ListNode second = current.next.next;
        first.next = second.next;
        current.next = second;
        current.next.next = first;
        current = current.next.next;
        }
    return dummy.next;
    }
     */ 
    
}
