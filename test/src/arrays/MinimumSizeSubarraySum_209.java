package arrays;

public class MinimumSizeSubarraySum_209 {
    
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length<1) return 0;
        
        int lo=0,hi=0,sum=0,minlen=Integer.MAX_VALUE;
        
        while(hi<nums.length){
            
            while (sum<s){                     // this loop could be one line:  if (sum<s) sum+=nums[hi++];       
                if (hi>=nums.length) break;    //                                   ↑  works without the "if" condition
                sum+=nums[hi++];               //  but I think the loop is easier to understand
            }            
                        
            while (sum>=s) {
                if (hi-lo<minlen) {
                    minlen=hi-lo;
                }
                sum-=nums[lo++];
            }
        }
        return minlen==Integer.MAX_VALUE? 0:minlen;
    }

}
