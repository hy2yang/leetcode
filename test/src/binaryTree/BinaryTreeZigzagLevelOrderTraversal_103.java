package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal_103 {
    // from left to right, then right to left for the next level and alternate between
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        boolean rev=false;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.offer(root);
        while (!s.isEmpty()) {
            int num=s.size();
            ArrayList<Integer> level=new ArrayList<>();
            TreeNode cur;
            for (int i=0;i<num;++i) {
                cur=s.poll();
                level.add(cur.val);
                if (cur.left!=null) s.offer(cur.left);
                if (cur.right!=null) s.offer(cur.right);
            }
            if (rev) Collections.reverse(level);
            res.add(level);            
        }
        return res;
    }

}
