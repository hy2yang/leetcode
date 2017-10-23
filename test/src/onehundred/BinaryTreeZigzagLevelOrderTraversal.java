package onehundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res =new ArrayList<>();
        if (root==null) return res;
        boolean reverse =false;
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
            if (reverse) Collections.reverse(level);
            res.add(level);
            reverse=!reverse;
        }
        return res;
        
    }

}
