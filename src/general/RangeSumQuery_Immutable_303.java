package general;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]
sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
public class RangeSumQuery_Immutable_303 {
    
    private int[] sums;
    
    public RangeSumQuery_Immutable_303(int[] nums) {
        sums=new int[nums.length+1];
        for (int i=1;i<sums.length;++i) {   // sums[i] sum from 0 to i (exclusive)
            sums[i]=sums[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j+1]-sums[i];   // j+1 to include j
    }

}
