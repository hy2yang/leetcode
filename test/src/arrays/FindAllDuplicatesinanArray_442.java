package arrays;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]

*/
public class FindAllDuplicatesinanArray_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res= new ArrayList<>();
        if (nums==null || nums.length<1) return res;
        
        for (int i=0;i<nums.length;++i) {  // nums from 1~n, index 0~n-1
            int pos= Math.abs(nums[i])-1;  // since all original numbers are positive, use negtive to store extra information
            if (nums[pos]<0) res.add(pos+1);
            nums[pos]=-nums[pos];          // if seen numbe x, filp nums[x-1]
        }
        return res;
    }
    
}
