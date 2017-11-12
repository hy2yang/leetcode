package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> level=new ArrayList<>();
            int num=q.size();
            TreeNode cur;
            for (int i=0;i<num;++i) {
                cur=q.poll();
                level.add(cur.val);
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);
                }
            res.add(level);
        }
        return res;
    }

}
