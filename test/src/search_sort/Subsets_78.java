package search_sort;

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

    public List<List<Integer>> subsets(int[] nums) {
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
