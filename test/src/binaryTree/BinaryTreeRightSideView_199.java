package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView_199 {
    
    public List<Integer> rightSideView(TreeNode root) {  // level order traversal, put last in level in res
        if (root==null) return new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        TreeNode cur;
        int level;
        q.offer(root);
        while (!q.isEmpty()) {
            level=q.size();
            while (level>0) {
                cur=q.poll();
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);
                --level;
                if (level==0) res.add(cur.val);
            }
        }
        return res;
    }

}
