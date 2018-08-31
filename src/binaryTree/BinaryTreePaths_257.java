package binaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {
    
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res=new ArrayList<>();
        if (root==null) return res;
        findPaths2String(res, root, new StringBuilder());
        return res;
    }
    
    private static void findPaths2String(ArrayList<String> res, TreeNode cur, StringBuilder sb) {        
        if (cur.left==null && cur.right==null) {
            sb.append(cur.val);
            res.add(sb.toString());
            return;
        }        
        sb.append(cur.val+"->");
        int len=sb.length();
        if(cur.left!=null) findPaths2String(res, cur.left, sb);
        sb.setLength(len);
        if(cur.right!=null)findPaths2String(res, cur.right, sb);    // pass stringBuilder, pass by value of the pointer, it still points to sb
        sb.setLength(len);                                          // so the function will change sb, must restore it
    }
    
    public List<String> binaryTreePaths2(TreeNode root) {
        ArrayList<String> res=new ArrayList<>();
        if (root==null) return res;
        findPaths2String2(res, root, "");
        return res;
    }
    
    private static void findPaths2String2(ArrayList<String> res, TreeNode cur, String s) {   
        s+=cur.val+"->";
        if (cur.left==null && cur.right==null) {
            if (s.length()>2) s=s.substring(0, s.length()-2);
            res.add(s);
            return;
        }        
        
        if(cur.left!=null)findPaths2String2(res, cur.left, s);             // if we pass String, since it's not object, pass by vlue 
        if(cur.right!=null)findPaths2String2(res, cur.right, s);           // passes a copy of s, won't change original s
    }

}
