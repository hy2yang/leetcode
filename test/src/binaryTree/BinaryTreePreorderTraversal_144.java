package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    
    public List<Integer> preorderTraversal_REC(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        preorderTraversal(root, res);
        return res;
    }
    
    private void preorderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root!=null) {
            res.add(root.val);
            preorderTraversal(root.left, res);
            preorderTraversal(root.right,res);   
        }
    }
    
    public List<Integer> preorderTraversal_ITER(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> s= new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            root=s.pop();
            res.add(root.val);
            if (root.right!=null) s.push(root.right);
            if (root.left!=null) s.push(root.left);            
        }
        return res;
    }

}
