package binaryTree;

/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2^h nodes inclusive at the last level h.
*/
public class CountCompleteTreeNodes_222 {

    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        else if (root.left==null) return 1;  // if left is null, right must be null
        else if (root.right==null) return 2; // if right is null. the tree ends here
        int h=0, fullNum=0;
        TreeNode cur=root;
        while (cur.left!=null) {
            cur=cur.left;            
            fullNum+=(1<<h);
            ++h;
        }
        return fullNum+countLowest(root,h);
    }
    
    private int countLowest(TreeNode root, int h) {
        if (h==1) {
            if (root.right!=null) return 2;
            else if (root.left!=null) return 1;
            else return 0;
        }
        
        TreeNode midLeaf=root.left;           // like binary search, midLeaf is root.left.right.right...right
        int depth=1;
        while (depth<h) {
            midLeaf=midLeaf.right;
            ++depth;
        }
        if (midLeaf==null) return countLowest(root.left, h-1);  // last node is on the left, check root.left.left.right.right...right
        else return (1<<(h-1))+countLowest(root.right, h-1);    // last node is on the right, add the left full half
                                                                // and check root.right.left.right.right....right
    }
    
}
