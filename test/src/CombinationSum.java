import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        int[] a= {2,3,6,7};
        System.out.print(combinationSum(a,7));
    }
    
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length<1) return new ArrayList<>();        
        Arrays.sort(candidates);        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> wip=new ArrayList<>();
        combinationSum(candidates,target,wip,res,0);
        return res;
    }
    static void combinationSum(int[] candidates, int target, List<Integer> wip, List<List<Integer>> res, int start){
        if (target==0) {
            res.add(new ArrayList<>(wip));
            return;
        }
        if (target<0) return;        
        else {
            for (int i=start;i<candidates.length;i++) {
                wip.add(candidates[i]);
                combinationSum(candidates,target-candidates[i],wip,res,i);
                wip.remove(wip.size()-1);
            }
        }
        return;        
    }
}
    /* old
    static void combinationSum(int[] candidates, int target, int n, List<Integer> wip, Set<List<Integer>> res){
        if (n*candidates[0]>target || n*candidates[candidates.length-1]<target) return;
        if (n==1) {
            int x=Arrays.binarySearch(candidates, target);
            if (x>-1) {
                wip.add(candidates[x]);
                Collections.sort(wip);
                res.add(wip);
            }            
            return;
        }
        else for (int i=0;i<candidates.length;i++) {
            ArrayList<Integer> copy=new ArrayList<Integer>(wip);
            copy.add(candidates[i]);
            combinationSum(candidates,target-candidates[i],n-1,copy,res);
        }
        return;        
    }
    */

/* backtrack
public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
*/
