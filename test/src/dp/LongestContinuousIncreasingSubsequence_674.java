package dp;
/*
Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 
Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1. 
*/
public class LongestContinuousIncreasingSubsequence_674 {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length<1) return 0;
        int lo=0,hi=0,res=1;
        while (hi<nums.length-1) {
            ++hi;
            if (nums[hi]>nums[hi-1]) {                
                if (hi-lo+1>res) res=hi-lo+1;
            }
            else {
                lo=hi;                
            }
        }
        return res;
    }
    
    public int findLengthOfLCIS_dp(int[] nums) {
        if (nums.length<1) return 0;
        int dp=1,res=1;
        for(int i=1;i<nums.length;++i){
            if (nums[i]>nums[i-1]) ++dp;
            else dp=1;
            if(dp>res) res=dp;
        }
        return res;
    }
}
