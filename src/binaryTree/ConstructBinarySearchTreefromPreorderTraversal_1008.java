package binaryTree;
/*
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node,
any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.
Also recall that a preorder traversal displays the value of the node first,
then traverses node.left, then traverses node.right.)


Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Note:

    1 <= preorder.length <= 100
    The values of preorder are distinct.
 */
public class ConstructBinarySearchTreefromPreorderTraversal_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, 0, preorder.length);
    }

    private TreeNode construct(int[] a, int lo, int hi){
        if (lo>=hi) return null;
        TreeNode root = new TreeNode(a[lo]);
        int p=lo+1;
        while (p<hi && a[p]<a[lo]) ++p;
        root.left = construct(a, lo+1,p);
        root.right = construct(a, p, hi);
        return root;
    }

}
