package linkedList;

public class SortList_148 {
    //Sort a linked list in O(n log n) time using constant space complexity.
    
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) return head;
        
        ListNode f=head,s=head,pre=null;
        while (f!=null && f.next!=null) {   // remember this findmedian loop
            f=f.next.next;
            pre=s;
            s=s.next;
        }
        pre.next=null;        
        
        return merge(sortList(head),sortList(s));        
    }
    
    ListNode merge(ListNode n1, ListNode n2) {
        ListNode d=new ListNode(0);
        ListNode p=d;
        while (n1!=null && n2!=null) {
            if (n1.val<n2.val) {
                p.next=n1;
                n1=n1.next;
            }
            else {
                p.next=n2;
                n2=n2.next;
            } 
            p=p.next;     //
        }
        if (n1==null) p.next=n2;
        if (n2==null) p.next=n1;
        return d.next;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
