package binaryTree;

public class BalancedBinaryTree_110 {
    // A height-balanced binary tree is defined as 
    // a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
    
    public boolean isBalanced(TreeNode root) {
        return balancedOrHeight(root)!=-1;
    }
    
    private int balancedOrHeight(TreeNode n) {
        if (n==null) return 0;
        int leftH=balancedOrHeight(n.left);
        int rightH=balancedOrHeight(n.right);
        if (Math.abs(leftH-rightH)>1 || leftH==-1 || rightH==-1 ) return -1;
        return 1+Math.max(leftH,rightH);
    }

}
