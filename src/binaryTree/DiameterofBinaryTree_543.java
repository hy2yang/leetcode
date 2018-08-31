package binaryTree;

/*Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/
public class DiameterofBinaryTree_543 {
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max=new int[1];                          // out in a array to ba an object
        lengthBelow(root,max);
        return max[0];
    }

    private int lengthBelow(TreeNode root, int[] max) {   // the return value does not include root
        if (root==null || (root.left==null && root.right==null)) return 0;
        
        int leftlen=0, rightlen=0;
        if (root.left!=null) leftlen=1+lengthBelow(root.left, max);
        if (root.right!=null) rightlen=1+lengthBelow(root.right, max);
        max[0]=Math.max(max[0],leftlen+rightlen);
        
        return Math.max(leftlen, rightlen);
    }
    

}
