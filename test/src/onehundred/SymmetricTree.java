package onehundred;

public class SymmetricTree {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    
    static boolean isMirror(TreeNode a, TreeNode b) {
        if (a==null && b==null) return true;
        if ( (a==null)^(b==null) ) return false;
        if (a.val!=b.val) return false;
        if (!isMirror(a.left,b.right)) return false;
        if (!isMirror(a.right,b.left)) return false;
        return true;
    }

}
