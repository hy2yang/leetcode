package binaryTree;

import java.util.ArrayDeque;

/*
Given a Binary Search Tree and a target number, 
return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9
Output: True

Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28
Output: False
*/
public class TwoSum4_InputisaBST {
    
    public boolean findTarget(TreeNode root, int k) {          // space logN (stack size: tree height) time N (iterate the tree)
        if (root==null) return false;
        ArrayDeque<TreeNode> left = new ArrayDeque<>();        // small on top
        ArrayDeque<TreeNode> right = new ArrayDeque<>();       // big on top
        
        TreeNode cur=root;
        
        while (cur!=null) {
            left.push(cur);
            cur=cur.left;
        }
        
        cur=root;
        while (cur!=null) {
            right.push(cur);
            cur=cur.right;
        }
        int sum;
        while (!left.isEmpty() && !right.isEmpty() && left.peek()!=right.peek()) {            
            sum=left.peek().val+right.peek().val;
            if (sum==k) return true;
            if (sum<k) {
                for (cur=left.pop().right; cur!=null ; cur=cur.left) left.push(cur);
            }
            if (sum>k) {
                for (cur=right.pop().left; cur!=null; cur=cur.right) right.push(cur);
            }            
        }
        
        return false;
    }
    
    

}
