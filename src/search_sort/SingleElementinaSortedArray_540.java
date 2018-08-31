package search_sort;
/*
Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. 
Find this single element that appears only once.

Example 1:
Input: [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:
Input: [3,3,7,7,10,11,11]
Output: 10
Note: Your solution should run in O(log n) time and O(1) space.
*/
public class SingleElementinaSortedArray_540 {

    public int singleNonDuplicate(int[] nums) {  // binary search, O(logN)
        int lo=0, hi=nums.length-1;
        while (lo!=hi) {
            int mid= lo+(hi-lo)/2;
            if (mid%2==1) --mid;                 // move mid to even position: start of a pair
            if (nums[mid]!=nums[mid+1]) hi=mid;  // target in front half, so mid and mid+1 are in different pairs
            else lo=mid+2;                       // target in back half, 
        }
        return nums[lo];
    }
    
    public int singleNonDuplicate2(int[] nums) { // bit manipulation, O(N)
        int mask=0;
        for (int i:nums) mask^=i;
        return mask;
    }
    
}
