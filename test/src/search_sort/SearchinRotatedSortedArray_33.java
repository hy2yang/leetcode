package search_sort;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class SearchinRotatedSortedArray_33 {

    public int search(int[] nums, int target) {
        if (nums==null || nums.length<1) return -1;
        int lo=0,hi=nums.length-1;
        
        while (lo<=hi) {
            int mid=lo+(hi-lo)/2;
            if (nums[mid]==target) return mid;
            if (nums[mid]>nums[hi]) {           // left sorted
                if (target<nums[mid] && target>=nums[lo]) hi=mid-1;   // attention to target>=nums[lo], target>nums[hi] won't work
                else lo=mid+1;
            }
            else {      // right sorted
                if (target>nums[mid] && target<=nums[hi]) lo=mid+1; // attention to target<=nums[hi]
                else hi=mid-1;
            }            
        }
        
        return -1;
    }
    
}
