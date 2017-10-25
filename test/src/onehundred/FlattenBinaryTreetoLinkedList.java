package onehundred;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        TreeNode head=root;
        while (head!=null) {
            TreeNode l= head.left;
            TreeNode r= head.right; 
            if (l==null && r==null) break;
            if (l==null) {
                head=head.right;
                continue;
            }
            head.right=l;
            head.left=null;
            TreeNode rEnd=head;
            while (rEnd.right!=null) rEnd=rEnd.right;
            rEnd.right=r;
            head=head.right;
        }
    }

}
