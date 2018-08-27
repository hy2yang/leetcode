package onehundred;

public class LinkedListCycle2 {

    public static void main(String[] args) {


    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null) {
            fast=fast.next;
            if (fast!=null) {
                slow=slow.next;
                fast=fast.next;
            }            
            if (slow==fast) {
                while (head!=fast) {
                    head=head.next;
                    fast=fast.next;
                }
                return head;
            }
        }
        return null;
    }

}
