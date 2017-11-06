package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.offer(root);
        while (!s.isEmpty()) {
            ArrayList<Integer> level=new ArrayList<>();
            int num=s.size();
            TreeNode cur;
            for (int i=0;i<num;++i) {
                cur=s.poll();
                level.add(cur.val);
                if (cur.left!=null) s.offer(cur.left);
                if (cur.right!=null) s.offer(cur.right);
                }
            res.add(level);
        }
        return res;
    }

}
