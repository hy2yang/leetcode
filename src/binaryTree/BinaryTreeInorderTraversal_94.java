package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    
    public List<Integer> inorderTraversal_REC(TreeNode root) {  // recursive
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        inorderTraversal(root,res);
        return res;
    }
    
    private void inorderTraversal(TreeNode n, ArrayList<Integer> res) {
        if (n!=null) {
            inorderTraversal(n.left,res);
            res.add(n.val);
            inorderTraversal(n.right,res);
        }
    }
    
    public List<Integer> inorderTraversal_ITER(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        //s.push(root);
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
