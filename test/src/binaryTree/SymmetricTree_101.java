package binaryTree;

import java.util.ArrayDeque;

public class SymmetricTree_101 {
    
    public boolean isSymmetric_REC(TreeNode root) {
        return isMirror(root,root);
    }
    
    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a==null && b==null) return true;
        if (a==null ^ b==null) return false;
        if (a.val!=b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right,b.left);
    }
    
    
    public boolean isSymmetric_ITER(TreeNode root) {
        if (root==null) return true;
        if (root.left==null ^ root.right==null) return false;
        if (root.left==null && root.right==null) return true;        
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.offer(root.left);
        q.offer(root.right);
        TreeNode l,r;
        while (!q.isEmpty()) {
            l=q.poll();
            r=q.poll();
            if (l.val!=r.val) return false;
            
            if (l.left!=null && r.right!=null) {
                q.offer(l.left);
                q.offer(r.right);
            }
            else if (l.left==null ^ r.right==null) return false;
            
            if (l.right!=null && r.left!=null) {
                q.offer(l.right);
                q.offer(r.left);
            }
            else if ( l.right==null ^ r.left==null) return false;          
        }
        return true;
    }

}
