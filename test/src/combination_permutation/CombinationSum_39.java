package combination_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
public class CombinationSum_39 {
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null || candidates.length<1) return new ArrayList<>();                
        Arrays.sort(candidates); 
        return combinationSum_rec(candidates, target, 0);
    }
    
    private List<List<Integer>>  combinationSum_rec(int[] candidates, int target, int start){         
        List<List<Integer>> res= new ArrayList<List<Integer>>();        
        for (int i=start;i<candidates.length;++i) {
            if (candidates[i]<target) {
                for (List<Integer> wip: combinationSum_rec(candidates, target-candidates[i], i)) {
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
    
    public List<List<Integer>> combinationSum_2(int[] candidates, int target) {
        if (candidates==null || candidates.length<1) return new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> wip=new ArrayList<>();   
        List<List<Integer>> res= new ArrayList<>();
        combinationSum_2(candidates, target, wip, 0, 0, res);
        return res;
    }
    
    private void combinationSum_2(int[] candidates, int target, List<Integer> wip, int pos, int start, List<List<Integer>> res ) {
        if (target<0 ) return;        
        if (target==0) {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.addAll(wip.subList(0, pos));
            res.add(temp);
            return;
        }        
        for (int i=start;i<candidates.length;++i) {
            if (wip.size()<=pos) {
                wip.add(candidates[i]);
            }
            else wip.set(pos, candidates[i]);
            combinationSum_2(candidates, target-candidates[i], wip, pos+1, i, res);
        }
    }
    
    

}
