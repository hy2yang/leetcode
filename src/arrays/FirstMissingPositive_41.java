package arrays;
/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

public class FirstMissingPositive_41 {

    public static int firstMissingPositive(int[] nums) {
        
        for (int i=0;i<nums.length;) {   // move every positive value to the position of its value, 1at0 ,2at1...
            if (nums[i]>0 && nums[i]<=nums.length && nums[i]!=i+1 && nums[i]!=nums[nums[i]-1]) {   // positive, in range, not inposition, not duplicate
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
            }
            else ++i;
        }
        for (int i=0;i<nums.length;++i) {   //find first location where the index doesn't match the value
            if (nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    
    public static void main(String[] args) {
        int[] a= {1,1};
        System.out.println(firstMissingPositive(a));
    }
    
}
