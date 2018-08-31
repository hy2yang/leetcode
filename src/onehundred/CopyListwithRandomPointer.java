package onehundred;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
    }

public class CopyListwithRandomPointer {
    
    public static RandomListNode copy(RandomListNode head) {
        if(head==null) return null;
        RandomListNode copy=head;
        while (head!=null) {
            RandomListNode d= new RandomListNode(head.label);
            d.next=head.next;
            head.next=d;
            head=d.next;
        }
        
        head=copy;
        while (head!=null) {            
            if (head.random!=null) {
                head.next.random=head.random.next;                
            }
            head=head.next.next;
        }
        
        head=copy;
        copy=copy.next;
        RandomListNode i=copy;
        while (head!=null) {
            head.next=head.next.next;
            if (i.next==null)break;
            i.next=i.next.next;
            head=head.next;
            i=i.next;            
        }        
        return copy;
    }
    
   
}
