package binaryTree;

import java.util.ArrayDeque;

public class FlattenBinaryTreetoLinkedList_114 {
    
/*  Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given
             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
   If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.             
*/
    
    public void flatten_ITER(TreeNode root) {  // iterative, pre-order traversal
        if (root==null) return; 
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.push(root);
        while (!s.isEmpty()) {
            root=s.pop();
            if (root.right!=null) s.push(root.right);
            if (root.left!=null) s.push(root.left);
            if (!s.isEmpty()) root.right=s.peek();
            root.left=null;
        }
    }
    
    public void flatten_ITER2(TreeNode root) {  // iterative, pionter manipulation
        if (root==null) return;
        TreeNode l,r;
        while (root!=null) {
            l=root.left;
            r=root.right;
            if (l==null && r==null) return;
            if (l==null) {
                root=root.right;
                continue;
            }
            root.left=null;
            root.right=l;
            TreeNode rmost=root;
            while (rmost.right!=null) rmost=rmost.right;
            rmost.right=r;
            root=root.right;
        }
    }
    
    public void flatten(TreeNode root) {   // from leetcode, interative and recursive
        if (root == null) return;        
        TreeNode left = root.left;
        TreeNode right = root.right;        
        root.left = null;        
        flatten(left);
        flatten(right);        
        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
    
    public void Flatten(TreeNode root) {           // from leetcode, can not quite understand 
        solve(root, null);
    }
    private TreeNode solve(TreeNode root, TreeNode last) {
        if(root == null) return last;
        root.right = solve(root.left, solve(root.right, last));
        root.left = null;
        return root;
    }
}
    
    

