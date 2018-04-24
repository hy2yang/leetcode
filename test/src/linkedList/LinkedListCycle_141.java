package linkedList;
/*
Given a linked list, determine if it has a cycle in it.
*/
public class LinkedListCycle_141 {
    
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
