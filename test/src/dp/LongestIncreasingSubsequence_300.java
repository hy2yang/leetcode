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
    
    /*tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:
    len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    len = 3   :      [4, 5, 6]            => tails[2] = 6
    We can easily prove that tails is a increasing array. 
    Therefore it is possible to do a binary search in tails array to find the one needs update.

    Each time we only do one of the two:
    (1) if x is larger than all tails, append it, increase the size by 1
    (2) if tails[i-1] < x <= tails[i], update tails[i]
    Doing so will maintain the tails invariant. The the final answer is just the size.*/

}
