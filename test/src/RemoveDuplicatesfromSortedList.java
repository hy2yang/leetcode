class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}   

public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode f=head;
        ListNode b=head;
        
        while(true){
            while (f.val==b.val){
                if (f.next==null) {
                    b.next=null;
                    return head;
                }
                f=f.next;
            }
            b.next=f;
            b=f;
        }
    }
}
