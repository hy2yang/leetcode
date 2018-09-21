package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
Consider all the leaves of a binary tree.
From left to right order, the values of those leaves form a leaf value sequence..

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

Note:
Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilarTrees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Integer[] arr1 = getLeaves(root1), arr2 = getLeaves(root2);
        if (arr1.length!=arr2.length) return false;
        for (int i=0 ;i<arr1.length;++i){
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    private Integer[] getLeaves(TreeNode root){
        if (root==null) return null;
        Deque<TreeNode> s = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (!s.isEmpty() || cur!=null){
            while (cur!=null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            if (cur.left==null && cur.right==null) res.add(cur.val);
            cur = cur.right;
        }
        return res.toArray(new Integer[0]);
    }
}
