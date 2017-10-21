package onehundred;

public class RemoveDuplicatesfromSortedList2 {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) return head;
          ListNode d= new ListNode(Integer.MAX_VALUE);
          d.next=head;
          ListNode f=head;
          ListNode b=d;
          while (f!=null) {
              while (f.next!=null && f.val==f.next.val ) {
                  f=f.next;
              }
              if (b.next!=f) {
                  b.next=f.next;
              }
              else b=b.next;
              f=f.next;
          }
          return d.next;
      }

}
