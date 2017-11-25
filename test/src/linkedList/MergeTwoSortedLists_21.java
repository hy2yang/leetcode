package linkedList;

public class MergeTwoSortedLists_21 {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode d=new ListNode(0);
        d.next= l1.val<=l2.val? l1:l2;        
        ListNode p=d.next;
        if (p==l1) l1=l1.next;
        else l2=l2.next;
        
        while (l1!=null && l2!=null) {
            p.next=l1.val<=l2.val? l1:l2;
            p=p.next;
            if (p==l1) l1=l1.next;
            else l2=l2.next;            
        }
        
        if (l2!=null) p.next=l2;
        else p.next=l1;
        
        return d.next;
    }

}
