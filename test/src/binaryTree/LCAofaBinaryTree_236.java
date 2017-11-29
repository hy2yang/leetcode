package binaryTree;
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor 
is defined between two nodes v and w as the lowest node in T that has both v and w as descendants 
(where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. 
Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
*/

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

public class LCAofaBinaryTree_236 {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==root || q==root) return root;
        if (p == q) return p;
        HashMap<TreeNode,TreeNode> map=new HashMap<>();
        ArrayDeque<TreeNode> stack=new ArrayDeque<>();
        TreeNode cur=root;
        stack.push(cur);
        map.put(cur, null);
        
        while(!map.containsKey(p) || !map.containsKey(q)) {
            cur=stack.pop();            
            if (cur.right!=null) {
                stack.push(cur.right);
                map.put(cur.right,cur);
            }
            if (cur.left!=null) {
                stack.push(cur.left);
                map.put(cur.left,cur);
            }
        }
        
        HashSet<TreeNode> toP=new HashSet<>();
        while(p!=null) {
            toP.add(p);
            p=map.get(p);
        }
        while (!toP.contains(q)) {
            q=map.get(q);
        }
        return q;
        
    }
        
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;
        if (p == q)
            return p;
        ArrayDeque<TreeNode> toP = new ArrayDeque<>(), toQ = new ArrayDeque<>();

        findPathDFS(root, p, toP, new ArrayDeque<TreeNode>());
        findPathDFS(root, q, toQ, new ArrayDeque<TreeNode>());

        for (TreeNode res : toP) {
            if (toQ.contains(res))
                return res;
        }
        return null;

    }

    private void findPathDFS(TreeNode root, TreeNode target, ArrayDeque<TreeNode> res, ArrayDeque<TreeNode> wip) {
        if (root == null) {
            return;
        }
        wip.push(root);
        if (root == target) {
            res.addAll(wip);
            return;
        }
        if (root.left != null)
            findPathDFS(root.left, target, res, wip);
        if (root.right != null)
            findPathDFS(root.right, target, res, wip);
        wip.pop();
    }
    
    public TreeNode lowestCommonAncestor_rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || p==root || q==root) return root;
        if (p == q) return p;
        TreeNode left=lowestCommonAncestor_rec(root.left,p,q);
        TreeNode right=lowestCommonAncestor_rec(root.right,p,q);
        if (left==null && right==null) return null;
        if (left!=null && right==null) return left;
        if (left==null && right!=null) return right;
        return root;
    }

}
