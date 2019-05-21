package binaryTree;
/*
Given a binary tree, each node has value 0 or 1.
Each root-to-leaf path represents a binary number starting with the most significant bit.
For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
Return the sum of these numbers modulo 10^9 + 7.

Example 1:
Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

Note:
    The number of nodes in the tree is between 1 and 1000.
    node.val is 0 or 1.
 */
public class SumofRootToLeafBinaryNumbers_1022 {

    public int sumRootToLeaf(TreeNode root) {
        return root==null? 0:dfs(root, 0);
    }

    private int dfs(TreeNode cur, int carry){
        int mod = 1000000007;
        carry = ((carry<<1)+cur.val)%mod;
        if (cur.left==null & cur.right==null) return carry;

        int res = 0;
        if (cur.left!=null) res+=dfs(cur.left, carry);
        if (cur.right!=null) res+=dfs(cur.right, carry);
        return res%mod;
    }
}
