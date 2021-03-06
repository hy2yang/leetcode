package arrays;
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
public class MajorityElement_169 {
    
    public int majorityElement(int[] nums) {
        int c=nums[0];
        int count=0;
        for (int i:nums) {
            if (i==c) ++count;
            else --count;
            if (count<1) {
                c=i;
                count=1;
            }
        }
        return c;
    }

}
