package arrays;
/*
Given an array of n integers where n > 1, nums, return an array output such that 
output[i] is equal to the product of all the elements of nums except nums[i].
Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].

Follow up:Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

import java.util.Arrays;

public class ProductofArrayExceptSelf_238 {
    
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];
        res[0]=1;        
        for (int i=1;i<res.length;++i) {
            res[i]=res[i-1]*nums[i-1]; 
        }
        int right=1;
        for (int i=nums.length-1;i>=0;--i) {            
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
    
    public int[] productExceptSelf2(int[] nums) {         // my version, slower due to copy, symmetric
        int[] res=Arrays.copyOf(nums,nums.length);
        int left=1,right=1;  
        
        for (int i=0;i<res.length;++i) {
            res[i]=left;
            left*=nums[i];            
        }
        for (int i=nums.length-1;i>=0;--i) {            
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
    

}
