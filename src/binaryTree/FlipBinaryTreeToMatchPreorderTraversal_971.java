package binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
A node in this binary tree can be flipped by swapping the left child and the right child of that node.
Consider the sequence of N values reported by a preorder traversal starting from the root.
Call such a sequence of N values the voyage of the tree.
(Recall that a preorder traversal of a node means we report the current node's value,
then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that
the voyage of the tree matches the voyage we are given.
If we can do so, then return a list of the values of all nodes flipped.
You may return the answer in any order.
If we cannot do so, then return the list [-1].
 */
public class FlipBinaryTreeToMatchPreorderTraversal_971 {

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> res = new ArrayList<>();
        return dfs(root, voyage, res, 0)==-1? Arrays.asList(-1):res;
    }

    //return -1 for invalid node, index of right child for valid node, modify res if there are any flips
    private int dfs(TreeNode cur, int[] v, List<Integer> res, int pos){
        if (cur == null) return pos;
        if (pos<0 || pos>=v.length || cur.val!=v[pos]) return -1;

        ++pos;

        if (cur.left!=null && cur.left.val!=v[pos] && cur.right!=null && cur.right.val==v[pos] ){
            res.add(cur.val);
            int next = dfs(cur.right,v,res,pos); //flip
            return dfs(cur.left, v, res, next);
        }

        int next = dfs(cur.left,v,res,pos);
        return dfs(cur.right, v, res, next);
    }

}
