package onehundred;

public class MinimumDepthofBinaryTree {
    
    public int minDepthRecursive(TreeNode root) {
        if (root==null) return 0;
        int lh=minDepthRecursive(root.left);
        int rh=minDepthRecursive(root.right);
        if (lh==0 || rh==0) return Math.max(lh, rh)+1;
        return Math.min(lh, rh)+1;
    }

}
