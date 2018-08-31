package bitManipulation;
/*
Given an array of numbers nums, in which exactly two elements appear only once 
and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/
public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int mask=0;
        
        for (int i: nums) {          // two single numbers are distinct, so at least 1 set bit in the XOR result.
            mask^=i;                 // Find out one such bit (using the right most one here)
        }                            // divide all numbers into two groups, one with that bit set, the other unset. 
                                     // two single numbers must fall into the two distrinct groups. XOR numbers in each group.        
        
        mask = mask & ~(mask-1); // get the right most set bit, x&-x or x&~(x-1)
                                 // mask-1 right most set bit turns 0, left unchanged, right 0s turn into 1s 
                                 // ~(mask-1) right most set bit=1, lefr are different from original, right are 0s (also 0s in original)
        int set=0, unset=0;
        for (int i:nums) {
            if ( (i&mask) ==0 ) unset^=i;
            else set^=i;
        }
        
        return new int[]{set,unset};
    }
    
}
