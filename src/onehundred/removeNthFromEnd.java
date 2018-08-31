package onehundred;
/*class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null) return null;
        ListNode hi= head;
        ListNode lo= head;
        for (int i=0;i<n;i++) {            
            hi=hi.next;
            if (hi==null) return head.next;
        }       
        hi=hi.next;        
        while (hi!=null) {
            hi=hi.next;
            lo=lo.next;
        }
        lo.next=lo.next.next;
        return head;
    }
    
    
}