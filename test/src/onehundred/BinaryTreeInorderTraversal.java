package onehundred;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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
    
    public List<Integer> inorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if (root==null) return res;
        Stack<TreeNode> s=new Stack<>();
        while (root!=null || !s.isEmpty()) {
            while (root!=null) {
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
    

}
