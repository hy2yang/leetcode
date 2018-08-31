package combination_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
public class CombinationSum2_40 {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates==null || candidates.length<1) return new ArrayList<>();         
        Arrays.sort(candidates); 
        return combinationSum2(candidates, target, 0);
    }
    
    private List<List<Integer>>  combinationSum2(int[] candidates, int target, int start){
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        for (int i=start;i<candidates.length;++i) {
            if(i > start && candidates[i] == candidates[i-1]) continue;   // since it's sorted, use this to jump over dup candidates
            if (candidates[i]<target) {
                for (List<Integer> wip:combinationSum2(candidates, target-candidates[i], i+1)) {   //i+1, current number can not be used again
                    wip.add(candidates[i]);
                    res.add(wip);
                }
            }
            else if (candidates[i]==target) {
                List<Integer> wip=new ArrayList<>();
                wip.add(candidates[i]);
                res.add(wip);
            }
            else break;
        }
        return res;
    }

}
