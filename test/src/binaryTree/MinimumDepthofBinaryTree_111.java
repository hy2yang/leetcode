package binaryTree;

import java.util.ArrayDeque;

public class MinimumDepthofBinaryTree_111 {
    
    public int minDepthRecursive(TreeNode root) {
        if (root==null) return 0;
        int leftH=minDepthRecursive(root.left);
        int rightH=minDepthRecursive(root.right);
        if (leftH==0 || rightH==0) return Math.max(leftH, rightH)+1;
        return Math.min(leftH, rightH)+1;
    }
    
    public int minDepth_ITER(TreeNode root) {
        if (root==null) return 0;
        int h=0;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.offer(root);
        TreeNode temp;
        while (!s.isEmpty()) {
            int num=s.size();
            for (int i=0;i<num;++i) {
                temp=s.poll();
                if (temp.left==null && temp.right==null) return ++h;
                if (temp.left!=null) s.offer(temp.left);
                if (temp.right!=null) s.offer(temp.right);
            }
            ++h;
        }
        return h;
    }

}
