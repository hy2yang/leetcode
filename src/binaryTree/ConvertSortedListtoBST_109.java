package binaryTree;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }

public class ConvertSortedListtoBST_109 {
    
    public TreeNode sortedListToBST(ListNode head) {  //no helper method
        if (head==null) return null;
        ListNode f=head;
        ListNode s=new ListNode(0);
        s.next=f;
        while (f!=null&&f.next!=null) {
            f=f.next.next;
            s=s.next;
        }
        TreeNode root=new TreeNode(s.next.val);
        ListNode back=s.next.next;
        if (s.next==head) head=null;       // attention to this line
        s.next=null;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(back);
        return root;
    }
    
    public TreeNode sortedListToBST_2(ListNode head) {  //with a helper method
        return helper(head,null);
    }
    
    private TreeNode helper(ListNode lo, ListNode hi) {
        if (lo==null) return null;
        ListNode f=lo,s=lo;
        while (f!=hi && f.next!=hi) {
            f=f.next.next;
            s=s.next;
        }
        TreeNode root=new TreeNode(s.val);
        root.left=helper(lo,s);
        root.right=helper(s.next,hi);
        return root;
    }

}
