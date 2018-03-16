package combination_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, 
return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class SubsetsII_90 {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        boolean[] used=new boolean[nums.length];
        Arrays.sort(nums);
        helper(res, nums, used, 0);        
        return res;
    }
    
    static void helper(List<List<Integer>> res, int[] nums, boolean[] used, int cur) {
        if (cur==nums.length) {
            List<Integer> temp=new ArrayList<>();
            for (int i=0;i<cur;i++) {
                if (used[i]) temp.add(nums[i]);     
            }
            res.add(temp);
        }
        else {            
            if ( !(cur>0 && nums[cur]==nums[cur-1] && !used[cur-1])) {  // add dup number only if already exist
                used[cur]=true;
                helper(res,nums,used,cur+1);
            }            
            used[cur]=false;
            helper(res,nums,used,cur+1);
        }
    }

}
