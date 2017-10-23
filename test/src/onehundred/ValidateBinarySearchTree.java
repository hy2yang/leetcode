package onehundred;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public boolean isValidBST_rec(TreeNode a) {
        return validate(a,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    static boolean validate(TreeNode a, long min, long max) {
        if (a==null) return true;
        if (a.val<=min || a.val>=max) return false;
        if (a.left!=null && a.left.val>=a.val) return false;
        if (a.right!=null && a.right.val<=a.val) return false;        
        return (validate(a.left,min, a.val) && validate(a.right, a.val, max));
    }
    
    // not good, use another data type long to deal with overfloat
    
    public boolean isValidBST(TreeNode a) {
        if (a==null) return true;
        Stack<TreeNode> s=new Stack<>();
        TreeNode p=null;
        while (a!=null || !s.isEmpty()) {
            while (a!=null) {
                s.push(a);
                a=a.left;
            }
            a=s.pop();
            if (p!=null && a.val<=p.val) return false;  // a is parent or to thr right of p
            p=a;
            a=a.right;
        }
        return true;
    }

}
