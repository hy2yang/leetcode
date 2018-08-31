package onehundred;

public class IntersectionofTwoLinkedLists {

    public static void main(String[] args) {


    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA,b=headB;
        while (a!=null && b!=null) {
            a=a.next;
            b=b.next;
        }
        int x=0;
        if (a==null && b==null) x=0;
        else if (a==null && b!=null) {
            while (b!=null) {
                b=b.next;
                --x;
            }
        }
        else if (a!=null && b==null) {
            while (a!=null) {
                a=a.next;
                ++x;
            }
        }
        a=headA;
        b=headB;
        if (x>=0) {
            for(;x>0;--x) {
                a=a.next;
            }
        }
        else {
            for(;x<0;++x) {
                b=b.next;
            }
        }
        
        while (a!=b) {
            a=a.next;
            b=b.next;
        }
        return a;
    }
    
  /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
*/
}
