package dp;

import java.util.Arrays;

/*
Given an array of non-negative integers, you are initially positioned at the first index of the array. 
Each element in the array represents your maximum jump length at that position. 
Your goal is to reach the last index in the minimum number of jumps. 

Given array A = [2,3,1,1,4] 
The minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
You can assume that you can always reach the last index.
*/

public class JumpGame2_45 {
    
    public int jump2(int[] nums) {        // O(n^2) TLE
        int[] n =new int[nums.length];
        Arrays.fill(n,Integer.MAX_VALUE);
        n[0]=0;
        for (int hi=1;hi<nums.length;++hi){
            for (int lo=0;lo<hi;++lo){
                if (hi-lo<=nums[lo] && n[hi]>n[lo]+1){
                    n[hi]=n[lo]+1;
                }                    
            }
        }
        return n[nums.length-1];        
    }
    
    public int jump(int[] nums) {
        int jumped=0, range=0, lastrange=0;
        for (int i=0;i<nums.length-1;++i){
            if (i+nums[i]>range) range=i+nums[i];
            if (i==lastrange){
                ++jumped;
                lastrange=range;
            }
        }
        return jumped;
    }
    

}
