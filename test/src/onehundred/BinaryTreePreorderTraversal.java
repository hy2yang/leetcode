package onehundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    
    public List<Integer> preorderTraversalREC(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        rechelper(res, root);
        return res;
    }
    
    static void rechelper(ArrayList<Integer> res, TreeNode root) {
        if (root==null) return;
        res.add(root.val);
        rechelper(res, root.left);
        rechelper(res, root.right);
    }
    
    public List<Integer> preorderTraversalITE(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        while (q.size()>0) {
            TreeNode cur=q.poll();
            res.add(cur.val);
            if (cur.right!=null) q.offerFirst(cur.right);
            if (cur.left!=null) q.offerFirst(cur.left);            
        }
        return res;
    }

}
