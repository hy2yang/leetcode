package binaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
In a binary tree, the root node is at depth 0,
and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth,
but have different parents.

We are given the root of a binary tree with unique values,
and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
 */
public class CousinsinBinaryTree_993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();
        int d=0, dx=-1, dy=-2;

        q.offer(root);

        while (!q.isEmpty()){
            for (int i = q.size();i>0;--i){
                TreeNode cur = q.poll();
                if (cur.val==x) dx = d;
                if (cur.val==y) dy = d;

                if (cur.left!=null && cur.right!=null){
                    if ((cur.left.val==x && cur.right.val==y) || (cur.left.val==y && cur.right.val==x)) return false;
                }
                if (cur.left!=null) q.offer(cur.left);
                if (cur.right!=null) q.offer(cur.right);
            }
            ++d;
        }
        return dx==dy;
    }
}
