package onehundred;

public class LinkedListCycle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public boolean hasCycle(ListNode head) {
        ListNode slow=head,fast=head;
        while (fast!=null) {
            fast=fast.next;
            if (fast!=null) {
                slow=slow.next;
                fast=fast.next;
            }            
            if (slow==fast) return true;
        }
        return false;
    }

}
