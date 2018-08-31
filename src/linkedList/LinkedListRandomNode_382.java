package linkedList;

import java.util.Random;

/*
Given a singly linked list, return a random node's value from the linked list. 
Each node must have the same probability of being chosen.
Note that the head is guaranteed to be not null, so it contains at least one node.

Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
*/
public class LinkedListRandomNode_382 {
    
    
    class Solution1{
        
        ListNode h;
        int count;
        Random rnd;        
       
        public Solution1(ListNode head) {
            rnd=new Random();
            this.h=head;
            while (head!=null) {
                head=head.next;
                ++count;
            }
        }
        
        public int getRandom() {
            ListNode p=h;
            int n=rnd.nextInt(count);
            for (int i=0;i<n;++i) {
                p=p.next;
            }
            return p.val;
        }
        
    }
    
    class Followup{
        ListNode h;
        Random rnd;
        
        public Followup(ListNode head) {
            rnd=new Random();
            this.h=head;            
        }
        
        public int getRandom() {            
            ListNode p=h, res=null;            
            for (int i=1;p!=null;++i) {
                if (rnd.nextInt(i)==0) res=p;
                p=p.next;
            }
            return res.val;
        }
        
    }
    
}
