package dp;

public class MaximumSubarray_53 {
    
    public int maxSubArray(int[] nums) {
        if(nums==null|| nums.length<1) return 0;
        int dp=nums[0],max=nums[0];                       // dp is the max sum that ends here at i
        for (int i=1;i<nums.length;++i) {
            dp=Math.max(dp+nums[i], nums[i]);
            max=Math.max(max, dp);
        }
        return max;
    }

}
