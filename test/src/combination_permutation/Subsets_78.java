package combination_permutation;

import java.util.ArrayList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Subsets_78 {
    
    public List<List<Integer>> subsets(int[] a) {
        return subsets_rec(a, a.length-1);
    }
    
    private List<List<Integer>> subsets_rec(int[] nums, int end) {
        List<List<Integer>> res= new ArrayList<>();
        if (end==-1) {
            res.add(new ArrayList<>());
            return res;
        }
        
        for (List<Integer> i :  subsets_rec(nums, end-1)) { 
            res.add(i);
            List<Integer> temp = new ArrayList<>(i);
            temp.add(nums[end]);
            res.add(temp);
        }
        return res;
    }
    

    public List<List<Integer>> subsets_dfs(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> wip, int[] nums, int pos) {  //pos: search start position
        res.add(new ArrayList<Integer>(wip));
        if (pos==nums.length) return;
        for (int i=pos;i<nums.length;++i) {
            wip.add(nums[i]);
            dfs(res, wip, nums, i+1);
            wip.remove(wip.size());
        }
    }
    
    
    
}
