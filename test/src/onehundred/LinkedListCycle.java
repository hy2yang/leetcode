package onehundred;

public class LinkedListCycle {

    public static void main(String[] args) {


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
