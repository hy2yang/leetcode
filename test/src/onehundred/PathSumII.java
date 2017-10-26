package onehundred;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<List<Integer>> res =new ArrayList<>();
        if (root==null) return res;
        ArrayList<Integer> wip =new ArrayList<>();
        findPathSum(res, wip, root, sum);
        return res;        
    }
    
    static void findPathSum(ArrayList<List<Integer>> res, ArrayList<Integer> wip,TreeNode root, int sum) {
        if (root==null) return;
        wip.add(root.val);
        if (root.left==null && root.right==null && sum==root.val) {            
            res.add(new ArrayList<Integer>(wip));
            wip.remove(wip.size()-1);
            return;
        }       
        
        if (root.left!=null) {
            findPathSum(res, wip, root.left, sum-root.val);            
        }        
        if (root.right!=null) {
            findPathSum(res, wip, root.right, sum-root.val);
        }
        wip.remove(wip.size()-1);
    }

}
