package onehundred;

import java.util.ArrayDeque;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
    }
 

public class PopulatingNextRightPointersinEachNode {
    
    public void connect(TreeLinkNode root) {                // use queue for inorder traversal, slower but can be used for un balanced BT
        if (root==null) return;
        ArrayDeque<TreeLinkNode> s=new ArrayDeque<>();
        s.add(root);
        while (!s.isEmpty()) {
            int i=s.size();
            for (; i>0;--i) {
                TreeLinkNode temp=s.poll();
                if (i!=1) temp.next=s.peek();                
                if (temp.left!=null) s.add(temp.left);
                if (temp.right!=null) s.add(temp.right);
            }            
        }        
    }
    
    public void connect2(TreeLinkNode root) {              // utilize the structure better, faster, but applies to only perfect BT
        if (root==null) return;
        TreeLinkNode pre=root;
        TreeLinkNode cur=null;
        while (pre.left!=null) {
            cur=pre;
            while (cur!=null) {
                cur.left.next=cur.right;
                if (cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            pre=pre.left;
        }
    }

}
