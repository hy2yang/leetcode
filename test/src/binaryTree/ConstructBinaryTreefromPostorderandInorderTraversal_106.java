package binaryTree;

import java.util.HashMap;

public class ConstructBinaryTreefromPostorderandInorderTraversal_106 {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length!=inorder.length) return null;
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;++i){
            map.put(inorder[i], i);
        }
        return helper(map, postorder, postorder.length-1, 0, postorder.length-1);
    }
    
    private TreeNode helper(HashMap<Integer, Integer> map, int[] post, int postpos, int lo, int hi){
        if(lo>hi || postpos<0) return null;
        TreeNode root=new TreeNode(post[postpos]);
        int inpos=map.get(post[postpos]);
        int rsize=hi-inpos;
        root.left=helper(map, post, postpos-1-rsize, lo, inpos-1);
        root.right=helper(map, post, postpos-1, inpos+1, hi);
        return root;
    }

}
