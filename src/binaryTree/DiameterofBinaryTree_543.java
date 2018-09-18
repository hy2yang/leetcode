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

    // returns max path length from cur to leaf
    // also updates max path length that passing cur node as apex
    private int lengthBelow(TreeNode cur, int[] max) {
        if (cur==null || (cur.left==null && cur.right==null)) return 0;

        int leftlen=0, rightlen=0;
        if (cur.left!=null) leftlen=1+lengthBelow(cur.left, max);
        if (cur.right!=null) rightlen=1+lengthBelow(cur.right, max);
        if (max[0]<leftlen+rightlen) max[0]=leftlen+rightlen;

        return leftlen>rightlen? leftlen:rightlen;
    }
    

}
