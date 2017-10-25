package onehundred;

public class ConvertSortedListtoBinarySearchTree {
    
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head,null);
    }
    
    static TreeNode helper(ListNode start, ListNode end) {
        if (start==end) return null;
        ListNode f=start,b=start;
        while (f!=end && f.next!=end) {
            f=f.next.next;
            b=b.next;
        }
        TreeNode root=new TreeNode(b.val);
        root.left=helper(start,b);
        root.right=helper(b.next,end);
        return root;
    }

}
