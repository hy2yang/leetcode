package onehundred;

import java.util.ArrayDeque;

public class MaximumDepthofBinaryTree {

    public static void main(String[] args) {
    }
    
    public int maxDepthRecursive(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(maxDepthRecursive(root.left), maxDepthRecursive(root.right));
    }
    
    public int maxDepth(TreeNode root) {    //try iterative
        if(root==null) return 0;
        ArrayDeque<TreeNode> a=new ArrayDeque<>();
        a.add(root);
        int d=0;
        while (!a.isEmpty()) {
            int nowinq=a.size();
            while (nowinq>0) {
                TreeNode t=a.poll();
                if (t.left!=null) a.add(t.left);
                if (t.right!=null) a.add(t.right);
                nowinq--;
            }
            d++;           
        }
        return d;
    }
    
    

}
