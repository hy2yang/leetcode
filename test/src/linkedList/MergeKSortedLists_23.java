package linkedList;

import java.util.Arrays;

//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

public class MergeKSortedLists_23 {
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        if (lists.length==1) return lists[0];
        if (lists.length==2) return mergeTwoLists(lists[0],lists[1]);
        int n=lists.length;
        return mergeTwoLists(mergeKLists(Arrays.copyOfRange(lists, 0, n/2)),mergeKLists(Arrays.copyOfRange(lists, n/2, n)));
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
    
    /*
    The complexity of mergeTwoLists  obviously is O(n), n is the sum of length of l1 and l2.
    The progress of combination is like a full binary tree, from bottom to top. 
    n nodes forms a binary tree, hight=log2(n), total O(nlog2(n));
     */
}
