package arrays;

import java.util.ArrayList;
import java.util.List;
/*
Given an integer array of size n, find all elements that appear more than n/3 times. 
The algorithm should run in linear time and in O(1) space.
*/
public class MajorityElement2_229 {
    
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res= new ArrayList<Integer>();
        if (nums==null || nums.length<1) return res;
        int c1=nums[0], c2=nums[0], count1=0,count2=0;
        
        for (int i : nums) {
            if (i==c1) ++count1;
            else if (i==c2) ++count2;              // these "else" matters A LOT
            else if (count1==0) {
                c1=i;
                count1=1;
            }
            else if (count2==0) {
                c2=i;
                count2=1;
            }
            else{
                --count1;
                --count2;
            }
        }
        
        count1=0;count2=0;
        for (int i : nums) {
            if (i==c1) ++count1;
            else if (i==c2) ++count2;
        }
        
        if (count1>nums.length/3) res.add(c1);
        if (count2>nums.length/3)  res.add(c2);
        return res;
    }   
    
}
