package dp;

public class MaximumProductSubarray_152 {
    
    public int maxProduct(int[] nums) {
        if(nums==null|| nums.length<1) return 0;
        int max=nums[0],dpmax=nums[0],dpmin=nums[0];
        for (int i=1;i<nums.length;++i) {
            if (nums[i]<0) {
                int temp=dpmax;
                dpmax=dpmin;
                dpmin=temp;
            }
            dpmax=Math.max(nums[i], dpmax*nums[i]);
            dpmin=Math.min(nums[i], dpmin*nums[i]);
            max=Math.max(dpmax,max);            
        }
        return max;
    }
    
}
