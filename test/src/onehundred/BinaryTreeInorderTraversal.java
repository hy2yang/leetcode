package onehundred;

import java.util.ArrayList;
import java.util.List;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

public class BinaryTreeInorderTraversal {
    
    // recursive, simple and easy to understand, slow, too
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (root==null) return res;
        helper(root,res);
        return res;                
    }
    
    public static void helper(TreeNode root, List<Integer> res) {
        if (root!=null) {
            helper(root.left,res);
            res.add(Integer.valueOf(root.val));
            helper(root.right,res);
        }
    }

}
