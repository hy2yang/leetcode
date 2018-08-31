package arrays;

/*
Given an array of integers that is already sorted in ascending order, 
find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target,
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

public class TwoSum2_InputSorted_167 {
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        if (nums==null || nums.length<2) return res;
        int lo=0,hi=nums.length-1;
        while (lo<hi){
            if (nums[lo]+nums[hi]==target){
                res[0]=lo+1;
                res[1]=hi+1;
                return res;
            }
            if(nums[lo]+nums[hi]<target){
                lo++;
                continue;
            }
            else{
                hi--;
                continue;
            }
        }
        return res;
    }
}
