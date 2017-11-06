package binaryTree;

public class Tree {
    public static TreeNode root;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        root = node;
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(10);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(11);
        
        // test tree here
        }

   
}
