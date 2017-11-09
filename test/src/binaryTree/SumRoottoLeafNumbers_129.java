package binaryTree;

public class SumRoottoLeafNumbers_129 {
    
/*Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
*/    
    
    public int sumNumbers_REC(TreeNode root) {
        return helper(root,0);
    }
    
    private int helper(TreeNode cur, int sum) {
        if (cur==null) return 0;
        if (cur.left==null && cur.right==null) return 10*sum+cur.val;
        return helper(cur.left, 10*sum+cur.val)+helper(cur.right,10*sum+cur.val);
    }

}
