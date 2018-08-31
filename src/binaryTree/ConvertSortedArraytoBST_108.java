package binaryTree;

public class ConvertSortedArraytoBST_108 {
    
    //Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    private TreeNode helper(int[] n, int lo, int hi) {
        if (lo>=hi) return null;
        int mid=lo+(hi-lo)/2;
        TreeNode root=new TreeNode(n[mid]);
        root.left=helper(n,lo, mid-1);
        root.right=helper(n,mid+1,hi);
        return root;
    }

}
