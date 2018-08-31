package binaryTree;
/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node 
to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
public class BinaryTreeMaximumPathSum_124 {
    
    public int maxPathSum(TreeNode root) { 
        int[] max = {Integer.MIN_VALUE};
        maxPathDown(root, max);
        return max[0];
    }
    
    private int maxPathDown(TreeNode node, int[] max) {      // 2 tasks 
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, max));
        int right = Math.max(0, maxPathDown(node.right, max));
        int topHere = left + right + node.val;
        if (topHere > max[0]) max[0]=topHere;       // task 1 : update global max when cur is the top;
        return Math.max(left, right) + node.val;    // task 2 : return the max from cur to a leaf
    }

}
