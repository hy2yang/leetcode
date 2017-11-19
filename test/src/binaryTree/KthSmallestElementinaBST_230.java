package binaryTree;

import java.util.ArrayDeque;

public class KthSmallestElementinaBST_230 {
    
    public int kthSmallest_ITER(TreeNode root, int k) {
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        int c=0;
        while(root!=null || !s.isEmpty()){            
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            root=s.pop();
            ++c;
            if (c==k) return root.val;
            root=root.right;
        }
        return Integer.MIN_VALUE;
    }
    
    public int kthSmallest_REC(TreeNode root, int k) {  // binary search
        int left=countNodes(root.left);
        if (left>=k) return kthSmallest_REC(root.left,k);
        else if (left+1==k) return root.val;
        else return kthSmallest_REC(root.right,k-left-1);
    }
    
    private int countNodes(TreeNode root){
        if (root==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
    public static void main(String[] args){
        //System.out.println(kthSmallest_ITER(new TreeNode(1),1));
    }

}
