package onehundred;

import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inmap=new HashMap<>();
        for (int i=0;i<inorder.length;i++) {
            inmap.put(inorder[i], i);  //to find position of a node in inorder quickly
        }
        return helper(inmap,inorder,postorder,postorder.length-1,0,inorder.length-1);
    }
    
    static TreeNode helper (HashMap<Integer,Integer> inmap, int[] inorder, int[] postorder, int postPos, int inStart, int inEnd) {
        if (inStart>inEnd || postPos<0) return null;
        TreeNode root=new TreeNode(postorder[postPos]);
        int inPos=inmap.get(postorder[postPos]);
        root.left= helper(inmap, inorder, postorder, postPos-(inEnd-inPos)-1, inStart, inPos-1);
        root.right=helper(inmap, inorder, postorder, postPos-1, inPos+1, inEnd);
        // inEnd-inPos == size of the right sub tree of a node
        return root;
    }

}
