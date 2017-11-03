package onehundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreePostorderTraversal {
    
    
    public List<Integer> postorderTraversalREC(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        rechelper(res, root);
        return res;
    }
    
    static void rechelper(ArrayList<Integer> res, TreeNode root) {
        if (root==null) return;        
        rechelper(res, root.left);
        rechelper(res, root.right);
        res.add(root.val);
    }
    
    public List<Integer> postorderTraversalITE(TreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        if (root==null) return res;
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.push(root);
        while (q.size()>0) {
            TreeNode cur=q.pop();
            res.add(cur.val);            
            if (cur.left!=null) q.push(cur.left);
            if (cur.right!=null) q.push(cur.right);
        }
        Collections.reverse(res);
        return res;
    }

}
