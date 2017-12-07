package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.
*/
public class AverageofLevelsinBinaryTree_637 {
    
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> res= new ArrayList<>();
        if (root==null) return res;
        
        ArrayDeque<TreeNode> q=new ArrayDeque<>();
        q.offer(root);
        
        int num;
        double sum;
        TreeNode cur;
        while (!q.isEmpty()) {
           num=q.size();
           sum=0;
           for (int i=0;i<num;++i) {
               cur=q.poll();
               sum+=cur.val;
               if (cur.left!=null) q.offer(cur.left);
               if (cur.right!=null) q.offer(cur.right);               
           }
           res.add(sum/num);           
        }
        return res;
    }

}
