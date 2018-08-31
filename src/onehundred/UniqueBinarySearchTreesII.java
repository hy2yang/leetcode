package onehundred;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {


    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n==0) return new ArrayList<>();
        return genTree(1,n);        
    }
    
    static List<TreeNode> genTree(int from, int to){
        ArrayList<TreeNode> res =new ArrayList<>();
        if (from==to) {
            res.add(new TreeNode(from));
            return res;
        }
        if (from>to) {
            res.add(null);
            return res;
        }
        for (int i=from;i<=to;++i) {
            List<TreeNode> left=genTree(from,i-1);
            List<TreeNode> right=genTree(i+1,to);            
            for (TreeNode l:left) {
                for (TreeNode r:right) {
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    res.add(root);
                }
            }
        }
        return res;
    }

}
