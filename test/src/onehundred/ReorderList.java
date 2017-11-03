package onehundred;

public class ReorderList {
    
    public static void reorderList(ListNode head) {
        if (head==null || head.next==null) return;
        ListNode fast=head.next,slow=head;
        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode back=slow.next;
        slow.next=null;
        back=reverseList(back);
        ListNode h2=head;
        ListNode t;
        while (h2!=null){
            t=h2.next;
            h2.next=back;
            h2=back;
            back=t;            
        }     
    }
    
    static ListNode reverseList(ListNode head){
        ListNode res=null,p=null;
        while (head!=null){
            p=head.next;
            head.next=res;
            res=head;
            head=p;            
        }
        return res;
    }
    
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        reorderList(a);

    }

}
