package binaryTree;

import java.util.ArrayDeque;

public class ValidateBST_98 {
    
    // The left subtree of a node contains only nodes with keys less than the node's key.     -whole child tree rather than a child node
    // The right subtree of a node contains only nodes with keys greater than the node's key.
    // Both the left and right subtrees must also be binary search trees.

    public boolean isValidBST(TreeNode a) {
        if (a==null) return true;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        TreeNode p=null;
        while (!s.isEmpty() || a!=null) {
            while (a!=null) {
                s.push(a);
                a=a.left;                
            }
            a=s.pop();
            if (p!=null && a.val<=p.val) return false;
            p=a;
            a=a.right;
        }
        return true;
    }   
    

}
