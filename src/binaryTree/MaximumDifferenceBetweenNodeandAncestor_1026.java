package binaryTree;
/*
Given the root of a binary tree, find the maximum value V for which there exists different nodes A and B
where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an ancestor of B.)


Example 1:
Input: [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
Explanation:
We have various ancestor-node differences, some of which are given below :
|8 - 3| = 5
|3 - 7| = 4
|8 - 1| = 7
|10 - 13| = 3
Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

Note:
    The number of nodes in the tree is between 2 and 5000.
    Each node will have value between 0 and 100000.

 */
public class MaximumDifferenceBetweenNodeandAncestor_1026 {

    public int maxAncestorDiff(TreeNode root) {
        int[] res = new int[1];
        rec(root, root.val, root.val, res);
        return res[0];
    }

    private void rec(TreeNode cur, int max, int min, int[] res){
        if (cur.val<min) min = cur.val;
        if (cur.val>max) max = cur.val;

        if (cur.left==null && cur.right==null) {
            if (res[0]< max-min) res[0]=max-min;
            return;
        }
        if (cur.left!=null) rec(cur.left, max, min, res);
        if (cur.right!=null) rec(cur.right, max, min, res);
    }
}
