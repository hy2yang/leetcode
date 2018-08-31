package onehundred;
import java.util.*;

public class PermutationsII {
    // nums includes duplicate
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<>();
        if(nums.length<1) return res;
        Arrays.sort(nums);
        boolean[] added=new boolean[nums.length];
        helper(nums,res,new ArrayList<Integer>(), added); 
        return res; 
     }
    
    static void helper (int[] nums, List<List<Integer>> res, List<Integer> wip, boolean[] added){
        if (wip.size()==nums.length){
            res.add(new ArrayList<Integer>(wip));
            return;
        }
        else {
            for (int i=0;i<nums.length;i++){                
                if (added[i]) continue;
                if (i>0 && nums[i]==nums[i-1] && !added[i-1]) continue;
                wip.add(nums[i]);
                added[i]=true;
                helper(nums,res,wip,added);
                wip.remove(wip.size()-1);
                added[i]=false;
            }
        }
    }
     
     public static void main(String args[]) {
         int[] a= {1,1,2};
         List<List<Integer>> x=permuteUnique(a);
         System.out.println(x);
     }
}
