package binaryTree;
/*
Return any binary tree that matches the given preorder and postorder traversals.
Values in the traversals pre and post are distinct positive integers.

Example 1:
Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]


Note:
1 <= pre.length == post.length <= 30
pre[] and post[] are both permutations of 1, 2, ..., pre.length.
It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class ConstructBinaryTreefromPreorderandPostorderTraversal_889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, post, new int[]{0},  0, post.length-1);
    }

    private TreeNode constructFromPrePost(int[] pre, int[] post, int[] prePos,  int postStart, int postEnd) {

        if (postStart>postEnd) return null;

        TreeNode root = new TreeNode(pre[prePos[0]++]);

        if (postStart==postEnd) return root;

        int mid = postStart;
        while (mid<post.length && post[mid]!=pre[prePos[0]]) ++mid;

        root.left = constructFromPrePost(pre, post, prePos, postStart, mid);
        root.right = constructFromPrePost(pre, post, prePos, mid+1, postEnd-1);

        return root;
    }

}
