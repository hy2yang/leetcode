package dp;

import java.util.Arrays;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence. 
For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101],therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length. 
Your algorithm should run in O(n2) complexity. 
*/

//Follow up: Could you improve it to O(n log n) time complexity? 

public class LongestIncreasingSubsequence_300 {
    
    public int lengthOfLIS2(int[] nums) {   // O(n2) time complexity
        if (nums.length<1) return 0;
        int[] lis=new int[nums.length];
        Arrays.fill(lis, 1);
        int max=1;
        for (int hi=1;hi<lis.length;++hi){
            for (int lo=0;lo<hi;++lo){
                if (nums[lo]<nums[hi] && lis[lo]+1>lis[hi]){
                    lis[hi]= lis[lo]+1;
                    if (lis[hi]>max) max=lis[hi];
                }
            }
        }
        return max;
    }
    
    public int lengthOfLIS(int[] nums) {  // Binary search O(nlogn) time
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x:nums){
            int lo=0,hi=size;
            while (lo<hi){
                int mid=lo+(hi-lo)/2;
                if (tails[mid]<x) lo=mid+1;
                else hi=mid;
            }
            tails[lo]=x;
            if (lo==size) ++size;
        }
        return size;
    }

}
