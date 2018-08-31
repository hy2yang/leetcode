package onehundred;

public class SumRoottoLeafNumbers {

    public static void main(String[] args) {


    }
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
        
    }
    
    static int helper(TreeNode root, int sum) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 10*sum+root.val;
        else return helper(root.left, 10*sum+root.val)+helper(root.right, 10*sum+root.val);
    }

}
