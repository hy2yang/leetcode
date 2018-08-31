package onehundred;
import java.util.*;

public class CombinationSumII {

    public static void main(String[] args) {
        int[] a= {2,2,3,6,7};
        System.out.print(combinationSum2(a,7));
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length<1) return new ArrayList<>();        
        Arrays.sort(candidates);        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> wip=new ArrayList<>();
        combinationSum2(candidates,target,wip,res,0);
        return res;
    }
    static void combinationSum2(int[] candidates, int target, List<Integer> wip, List<List<Integer>> res, int start){
        if (target==0) {
            res.add(new ArrayList<>(wip));
            return;
        }
        if (target<0) return;        
        else {
            for (int i=start;i<candidates.length;i++) {
                if(i > start && candidates[i] == candidates[i-1]) continue;
                wip.add(candidates[i]);
                combinationSum2(candidates,target-candidates[i],wip,res,i+1);
                wip.remove(wip.size()-1);
            }
        }
        return;        
    }

}
