package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    
    public List<Integer> postorderTraversal_REC(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        postorderTraversal(root, res);
        return res;
    }
    
    private void postorderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (root!=null) {            
            postorderTraversal(root.left, res);
            postorderTraversal(root.right,res); 
            res.add(root.val);
        }
    }
    
    public List<Integer> postorderTraversal_ITER(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            root=s.pop();
            res.add(root.val);            
            if (root.left!=null) s.push(root.left);          // notice the order
            if (root.right!=null) s.push(root.right);
        }
        Collections.reverse(res);
        return res;
    }

}
