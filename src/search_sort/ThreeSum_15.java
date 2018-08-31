package search_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {       // O(N^2), better than have 2 and binarySearch for 3rd O(N^2*logN)
        List<List<Integer>> res= new ArrayList<>();
        if (nums==null || nums.length<3) return res;
        Arrays.sort(nums);
        
        int lo, hi;
        for (int i=0;i<nums.length-2;++i) {
            if (nums[i]>0) break; // since array sorted, if i>0 then following int must be>0 , can never sum to 0;
            if (i>0 && nums[i]==nums[i-1]) continue;
            
            lo=i+1; 
            hi=nums.length-1;            
            while (lo<hi) {                
                if (nums[lo]+nums[hi]==-nums[i]) {
                    res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));  
                    while (lo+1<hi && nums[lo]==nums[lo+1]) ++lo;                    
                    while (lo<hi-1 && nums[hi]==nums[hi-1]) --hi;
                    ++lo;
                    --hi;
                }
                else if (nums[lo]+nums[hi]<-nums[i]) ++lo;
                else --hi;
            }
        }
        return res;
    }
    
}
