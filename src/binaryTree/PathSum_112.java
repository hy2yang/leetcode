package binaryTree;

import java.util.ArrayList;

public class PathSum_112 {
    
    // Given a binary tree and a sum, determine if the tree has 
    // a root-to-leaf path such that adding up all the values along the path equals the given sum.
    
    public boolean hasPathSum(TreeNode root, int sum) {  // in recursion, think of base/last situations
        if (root==null) return false;   
        if (root.left==null && root.right==null) return root.val==sum;
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    
    public boolean hasPathSum_BT(TreeNode root, int sum) {
        if (root==null) return false;
        ArrayList<ArrayList<TreeNode>> res=new ArrayList<>();
        ArrayList<TreeNode> path =new ArrayList<>();
        helper(res,path,root,sum);
        return !res.isEmpty();
    }
    
    private void helper(ArrayList<ArrayList<TreeNode>> res, ArrayList<TreeNode> path, TreeNode cur, int sum) {
        if (cur==null) return;
        path.add(cur);
        
        if (cur.left==null && cur.right==null && sum==cur.val) {           
            res.add(new ArrayList<TreeNode>(path));
            return;
        }
        
        if (cur.left!=null) {
            helper(res,path,cur.left,sum-cur.val);
        }
        
        if (cur.right!=null) {
            helper(res,path,cur.right,sum-cur.val);            
        }
        path.remove(path.size()-1);
    }

}
