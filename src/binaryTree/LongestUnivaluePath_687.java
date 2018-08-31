package binaryTree;

/*
Given a binary tree, find the length of the longest path where each node 
in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:
Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:
2

Example 2:
Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:
2
Note: The given binary tree has not more than 10000 nodes. 
The height of the tree is not more than 1000.
*/
public class LongestUnivaluePath_687 {
	
	public int longestUnivaluePath_faster(TreeNode root) {
		if (root==null) return 0;
		int[] max = {0};
		getLen(root, root.val, max);
		return max[0];
	}
	
	private int getLen(TreeNode cur, int val, int[] max) {
		if (cur==null) return 0;
        
		int left = getLen(cur.left, cur.val, max);
        int right = getLen(cur.right, cur.val, max);
        if (left+right>max[0]) max[0] = left+right;
        
        if (cur.val != val) return 0;
        return left>right? ++left:++right;        
	}
	
	
	
	public int longestUnivaluePath(TreeNode root) {
		if (root==null) return 0;
		int[] max = {0};
		getLen(root, max);
		return max[0];
	}
	
	private int getLen(TreeNode cur, int[] max) {
		if (cur==null || cur.left==null && cur.right==null) return 0;
		int left = getLen(cur.left, max);
        int right = getLen(cur.right, max);
        left = (cur.left != null && cur.left.val == cur.val)? left+1:0;
        right = (cur.right != null && cur.right.val == cur.val)? right+1:0;
		if (left+right>max[0]) max[0] = left+right;		
		return (left>right)? left:right;
	}

}
