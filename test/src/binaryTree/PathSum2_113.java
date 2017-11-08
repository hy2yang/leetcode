package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2_113 {
    
    //Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {        
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if (root==null) return res;
        List<Integer> path =new ArrayList<>();
        helper(res,path,root,sum);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> path, TreeNode cur, int sum) {
        if (cur==null) return;
        path.add(cur.val);
        
        if (cur.left==null && cur.right==null && sum==cur.val) {           
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size()-1);
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
