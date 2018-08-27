package onehundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    public static void main(String[] args) {

        int[] a= {1,2,2};
        subsetsWithDup(a);
    }
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        int[] bi=new int[nums.length];
        Arrays.sort(nums);
        helper(res, nums, bi, 0);        
        return res;
    }
    
    static void helper(ArrayList<List<Integer>> res, int[] nums, int[] bi, int cur) {
        if (cur>=nums.length) {
            ArrayList<Integer> temp=new ArrayList<>();
            for (int i=0;i<cur;i++) {
                if (bi[i]==1) {
                    temp.add(nums[i]); 
                }                
            }
            res.add(temp);
        }
        else {
            for (int i=0;i<2;i++) {
                bi[cur]=i;
                if ( i==1 && cur>0 && nums[cur]==nums[cur-1] && bi[cur-1]==0) continue;  // avoid dup in results: if the element is 
                helper(res,nums,bi,cur+1);                                               // the same with former, not going if the former
            }                                                                            // is not added
        }
    }

}
