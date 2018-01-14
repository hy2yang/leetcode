package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements of [1, n] inclusive that do not appear in this array.
Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[5,6]
*/
public class FindAllNumbersDisappearedinanArray_448 {  
    
    public List<Integer> findDisappearedNumbers(int[] nums) {  // index 0~n-1, if see x, make nums[x-1] negtive
        for (int i=0;i<nums.length;++i) {
            int pos=Math.abs(nums[i])-1;
            if (nums[pos]>0) nums[pos]=-nums[pos];
        }
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<nums.length;++i) {    // if nums[x] is positive, then x+1 is not seen
            if (nums[i]>0) res.add(i+1);
        }
        return res;        
    }
    
    public List<Integer> findDisappearedNumbers_2(int[] nums) { // use O(n) extra space
        Set<Integer> s=new HashSet<>();
        for (int i=0;i<nums.length;++i) {
            s.add(nums[i]);            
        }
        List<Integer> res=new ArrayList<>();
        for (int i=1;i<=nums.length;++i) {
            if (!s.contains(i)) res.add(i);
        }
        return res;
    }

}
