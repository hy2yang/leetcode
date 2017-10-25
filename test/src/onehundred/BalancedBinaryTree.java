package onehundred;

public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        return balancedH(root)!=-1;
    }
    
    static int balancedH(TreeNode root) {
        if (root==null) return 0;
        int lh=balancedH(root.left);
        int rh=balancedH(root.right);
        if (lh==-1 || rh==-1) return -1;
        if (Math.abs(lh-rh)>1) return -1;
        return Math.max(lh, rh)+1;
    }

}
