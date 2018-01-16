package dp;
/*
A sequence of numbers is called a wiggle sequence if the differences between successive numbers 
strictly alternate between positive and negative. 
The first difference (if one exists) may be either positive or negative. 
A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. 
In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, 
the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. 
A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, 
leaving the remaining elements in their original order.

Examples:
Input: [1,7,4,9,2,5]
Output: 6
The entire sequence is a wiggle sequence.

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
*/
public class WiggleSubsequence_376 {
    
    public int wiggleMaxLength1(int[] nums) { // save space, but tricky
        if (nums==null) return 0;
        if (nums.length<2) return nums.length;
        
        int index=1;
        while( (index<nums.length) && (nums[index] == nums[index-1]) ) ++index;   // skip dupliactes in start
        if ( index>=nums.length) return 1; 
        
        boolean asc=nums[index]>nums[0];
        int res=1;
        for (int i=index;i<nums.length;++i) {
            if ( ( asc && nums[i]>nums[i-1] ) || ( !asc && nums[i]<nums[i-1]) ) {
                asc=!asc;
                ++res;
            }
        }
        return res;
    }
    
    public int wiggleMaxLength2(int[] nums) {         // O(n) time O(n) space dp;
        if (nums==null || nums.length<1) return 0;
        int[] asc=new int[nums.length];
        int[] desc=new int[nums.length];
        asc[0]=1;
        desc[0]=1;
        for (int i=1;i<nums.length;++i) {
            if (nums[i]>nums[i-1]) {
                asc[i]=desc[i-1]+1;
                desc[i]=desc[i-1];
            }
            else if (nums[i]<nums[i-1]) {
                desc[i]=asc[i-1]+1;
                asc[i]=asc[i-1];
            }
            else {
                asc[i]=asc[i-1];
                desc[i]=desc[i-1];
            }
        }
        return asc[nums.length-1]>=desc[nums.length-1]? asc[nums.length-1]:desc[nums.length-1];
    }

}
