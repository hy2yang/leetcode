package onehundred;

public class ConvertSortedArraytoBinarySearchTree {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
    
    static TreeNode helper(int[] nums, int lo, int hi) {
        if (lo>hi) return null;
        int mid = lo+(hi-lo)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,lo,mid-1);
        root.right=helper(nums,mid+1,hi);
        return root;
    }

}
