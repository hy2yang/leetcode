package onehundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2 {
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> res =new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> aux=new ArrayDeque<>();
        aux.offer(root);
        TreeNode p;        
        while (!aux.isEmpty()) {
            int thislevel=aux.size();
            ArrayList<Integer> level=new ArrayList<>();
            for (int i=thislevel;i>0;i--) {
                p=aux.poll();
                level.add(p.val);
                if(p.left!=null) aux.offer(p.left);
                if(p.right!=null) aux.offer(p.right);
            }
            res.add(level);            
        }
        Collections.reverse(res);
        return res;
        
    }

}
