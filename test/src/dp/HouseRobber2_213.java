package dp;

/*
After robbing those houses on that street, the thief has found himself a new place for his thievery. 
This time, all houses are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.
Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
*/

public class HouseRobber2_213 {
    
    // if i is not robbed, then you are free to choose whether to rob house i + 1
    // break the circle by assuming a house is not robbed.
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));  //not rob last VS not rot 1st
    }
    
    public int rob(int[] nums, int lo, int hi) {
        int robcur=0, robpre=0;
        for (int i=lo;i<=hi;++i) {
            int temp=robcur;
            robcur=Math.max(robpre+nums[i], robcur);
            robpre=temp;
        }
        return robcur>robpre? robcur:robpre;
    }

}
