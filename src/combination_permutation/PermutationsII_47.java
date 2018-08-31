package combination_permutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
public class PermutationsII_47 {
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) return res;
        permute(res, nums, 0);
        return res;
    }
    
    private void permute(List<List<Integer>> res, int[] nums, int pos) {
        if (pos == nums.length) { 
            List<Integer> toadd = new ArrayList<Integer>(nums.length);
            for (int i: nums) toadd.add(i);
            res.add(toadd);
            return;
        }
        
        Set<Integer> used = new HashSet<>();
        for (int i=pos; i<nums.length; ++i) {
            if (used.add(nums[i])) {   // avoid dup : use one permutation from start to pos as base only once
                swap(nums, pos, i);
                permute(res, nums, pos+1);
                swap(nums, pos, i);
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
