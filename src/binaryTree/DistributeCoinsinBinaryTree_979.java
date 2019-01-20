package binaryTree;

/*
Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.
(The move may be from parent to child, or from child to parent.)
Return the number of moves required to make every node have exactly one coin.

Example 1:
Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.

Example 2:
Input: [0,3,0]
Output: 3
Explanation: From the left child of the root, we move two coins to the root [taking two moves].
Then, we move one coin from the root of the tree to the right child.

Example 3:
Input: [1,0,2]
Output: 2

Example 4:
Input: [1,0,0,null,3]
Output: 4

Note:
1<= N <= 100
0 <= node.val <= N
 */
public class DistributeCoinsinBinaryTree_979 {

    public int distributeCoins(TreeNode root) {
        int[] res = new int[]{0};
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode cur, int[] res){
        if (cur==null) return 0;

        int l = dfs(cur.left, res);
        int r = dfs(cur.right, res);

        res[0] += l<0? -l:l;
        res[0] += r<0? -r:r;

        // new unit: move, move = coin X step
        // positive:surplus; negative:shortage
        return l+r+cur.val-1;
    }
}
