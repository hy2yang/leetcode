package onehundred;

import java.util.Stack;

public class ReverseLinkedList {
    
    public static ListNode reverseList2(ListNode head) {  //use stack, slow
        if (head==null) return head;
        Stack<ListNode> s=new Stack<>();
        while (head!=null) {
            s.push(head);
            head=head.next;
        }
        ListNode res=s.pop();
        ListNode i=res;
        while(s.size()!=0) {
            i.next=s.pop();
            i=i.next;
        }
        i.next=null;
        return res;        
    }
    
    public ListNode reverseList(ListNode head) {
        ListNode d=null, res=null;
        while (head!=null) {
            d=head.next;
            head.next=res;
            res=head;
            head=d;
        }
        return res;
    }
    
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        a.next=new ListNode(2);
        reverseList2(a);

    }

}
