package binaryTree;

import java.util.ArrayDeque;

/*Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
public class SumofLeftLeaves_404 {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null) return 0;
        int res=0;
        if (root.left!=null && root.left.left==null && root.left.right==null) res=root.left.val;
        return res+sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }
    
    public int sumOfLeftLeaves_ITER(TreeNode root) {
        if (root==null ) return 0;
        int res=0;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.push(root);
        TreeNode cur;
        while (!s.isEmpty()) {
            cur=s.pop();
            if (cur.left!=null) {
                if(cur.left.left==null && cur.left.right==null) res+=cur.left.val;
                else s.push(cur.left);
            }
            
            if (cur.right!=null) s.push(cur.right);
        }
        return res;
    }

}
