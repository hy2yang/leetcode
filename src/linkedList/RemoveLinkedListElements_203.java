package linkedList;

//Remove all elements from a linked list of integers that have value val.

public class RemoveLinkedListElements_203 {
    
    public ListNode removeElements(ListNode head, int val) {
        ListNode d=new ListNode(0);
        d.next=head;
        ListNode lo=d,hi=head;
        while (hi!=null) {
            if (hi.val==val) {
                lo.next=hi.next;
                hi=lo.next;
                continue;
            }
            hi=hi.next;
            lo=lo.next;            
        }
        return d.next;
    }

}
