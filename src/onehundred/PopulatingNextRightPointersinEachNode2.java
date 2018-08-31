package onehundred;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersinEachNode2 {
    
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
    
    public void connect2(TreeLinkNode root) { 
        if (root==null) return;
        TreeLinkNode head=new TreeLinkNode(0);       //dummy head of the level
        while (root!=null) {
            TreeLinkNode cur=head;
            while(root!=null) {
                if (root.left!=null) {
                    cur.next=root.left;
                    cur=cur.next;
                }
                if (root.right!=null) {
                    cur.next=root.right;
                    cur=cur.next;
                }
                root=root.next;              //  level order move
            }            
            root=head.next;                  // to next level
            head.next=null;                  // detach to reuse dummy
        }        
    }

}
