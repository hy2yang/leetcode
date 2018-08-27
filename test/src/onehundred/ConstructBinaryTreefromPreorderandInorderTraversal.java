package onehundred;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

    public static void main(String[] args) {

    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> inmap=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            inmap.put(inorder[i], i);  //to find position of a node in inorder quickly
        }
        return helper(inmap,preorder,inorder,0,0,inorder.length-1);
    }
    
    static TreeNode helper (HashMap<Integer,Integer> inmap, int[] preorder, int[] inorder, int prePos, int inStart, int inEnd) {
        if (inStart>inEnd || prePos>preorder.length-1) return null;
        TreeNode root=new TreeNode(preorder[prePos]);
        int inPos=inmap.get(root.val);
        root.left= helper(inmap, preorder, inorder, prePos+1, inStart, inPos-1);
        root.right=helper(inmap, preorder, inorder, prePos+(inPos-inStart)+1, inPos+1, inEnd);
        // prePos+(inPos-inStart)+1 : inPos-inStart == size of the left sub tree of a node, from prePos walk size+1, is the right node
        return root;
    }

}
