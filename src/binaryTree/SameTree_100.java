package binaryTree;

public class SameTree_100 {
    //Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null ^ q==null) return false;
        if (q.val!=p.val) return false;
        return isSameTree(p.left,q.left)&& isSameTree(p.right,q.right);
    }

}
