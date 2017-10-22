package onehundred;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head==null || head.next==null) return head;
        ListNode d= new ListNode(Integer.MAX_VALUE);
        d.next=head;
        ListNode a=d;        
        
        for (int i=0;i<m-1;i++) {
            a=a.next;
        }
        ListNode b=a.next;
        ListNode c=b.next;
        
        for (int i=0;i<n-m;i++) {
            b.next=c.next;
            c.next=a.next;   
            a.next=c;      //do not edit a.next first!
            c=b.next;
        }
        return d.next;       
        
    }

}
