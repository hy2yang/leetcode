package binaryTree;

import java.util.ArrayDeque;

public class BinarySearchTreeIterator_173 {
    
    public class BSTIterator {
        private ArrayDeque<TreeNode> stack;

        public BSTIterator(TreeNode root) {            
            stack=new ArrayDeque<>();
            while (root!=null) {
                stack.push(root);
                root=root.left;
            }
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur=stack.pop();
            int res=cur.val;
            if (cur.right!=null) {
                cur=cur.right;                
                while (cur!=null) {
                    stack.push(cur);
                    cur=cur.left;
                }
            }
            return res;            
        }
    }

    /**
     * Your BSTIterator will be called like this:
     * BSTIterator i = new BSTIterator(root);
     * while (i.hasNext()) v[f()] = i.next();
     */

}
