package binaryTree;

import java.util.ArrayDeque;

public class MaximumDepthofBinaryTree_104 {
    
    public int maxDepthRecursive(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }
    
    public int maxDepth_ITER(TreeNode root) {
        if (root==null) return 0;
        int h=0;
        ArrayDeque<TreeNode> s=new ArrayDeque<>();
        s.offer(root);
        TreeNode temp;
        while (!s.isEmpty()) {
            int num=s.size();
            for (int i=0;i<num;++i) {
                temp=s.poll();
                if (temp.left!=null) s.offer(temp.left);
                if (temp.right!=null) s.offer(temp.right);
            }
            ++h;
        }
        return h;
    }

}
