package arrays;
/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public int[] twoSum_updated(int[] nums, int target) {
        Map<Integer, Integer> m= new HashMap<>();
        for (int i=0;i<nums.length;++i){
            if (m.containsKey(nums[i])){
                return new int[]{i, m.get(nums[i])};
            }
            else {
                m.put(target-nums[i], i);
            }
        }
        return null;
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] res=new int[2];
        if (nums==null || nums.length<2) return res;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;++i){
            if (map.containsKey(target-nums[i])){
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            else map.put(nums[i],i);   // if selected number have duplicate in array
                                       // index of first is the front one of the dups
                                       // index of second is the back one of the dups
        }        
        return res;
        
    }

}
