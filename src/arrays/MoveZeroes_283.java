package arrays;
/*
Given an array nums, write a function to move all 0's to the end of it 
while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0]
*/

public class MoveZeroes_283 {
    
    /* from github
    Idea: Set leftMostZeroIndex to 0. Iterate through the array, at each iteration i, 
    if nums[i] != 0 and i > leftMostZeroIndex, replace the leftmost zero element nums[leftMostZeroIndex] with nums[i], 
    and set nums[i] to 0.
    Note: i == leftMostZeroIndex happens when nums has leading non-zero elements, 
    e.g., nums = {2, 1, 3, 0, 5, 0, 6}. 
    In such a case, don't perform any swap, keep incrementing i and leftMostZeroIndex until i > leftMostZeroIndex.
    */
    
    public void moveZeroes(int[] nums) {
        int first0=0;
        for (int i=0;i<nums.length;++i) {
            if (nums[i]!=0) {
                if(i>first0) {
                    nums[first0]=nums[i];
                    nums[i]=0;
                }
                ++first0;
            }
        }
    }

}
