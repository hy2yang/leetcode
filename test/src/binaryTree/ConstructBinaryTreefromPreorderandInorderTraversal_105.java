package binaryTree;

import java.util.HashMap;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length!=inorder.length) return null;
        HashMap<Integer, Integer> map=new HashMap<>();
        for (int i=0;i<inorder.length;++i){
            map.put(inorder[i], i);
        }
        return helper(map, preorder, 0, 0, map.size()-1);
    }
    
    private TreeNode helper(HashMap<Integer, Integer> map, int[] pre, int prepos, int lo, int hi){
        if(lo>hi || prepos>pre.length-1) return null;
        TreeNode root=new TreeNode(pre[prepos]);
        int inpos=map.get(pre[prepos]);
        int lsize=inpos-lo;
        root.left=helper(map, pre, prepos+1, lo, inpos-1);
        root.right=helper(map, pre, prepos+1+lsize, inpos+1, hi);
        return root;
    }

}
