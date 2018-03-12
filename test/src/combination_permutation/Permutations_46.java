package combination_permutation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
public class Permutations_46 {
    
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();   // res is also a queue
        res.add(new ArrayList<Integer>());
        for (int i : nums){            
            int size = res.size();            
            while (size>0){
                List<Integer> cur = res.poll();
                for (int pos=0; pos<=cur.size(); ++pos){
                    List<Integer> toAdd = new ArrayList<>(cur);
                    toAdd.add(pos, i);
                    res.add(toAdd);
                }
                --size;
            }            
        }        
        return res;
    }
    
    public List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res,nums,0);
        return res;
    }
    
    private static void helper(List<List<Integer>> res, int[] nums, int pos){
        if(pos==nums.length-1){   
            List<Integer> toadd = new ArrayList<Integer>(nums.length);
            for (int i: nums) toadd.add(i);
            res.add(toadd);
        }
        else{
            for(int i=pos; i<nums.length; i++){
                swap(nums, i, pos);
                helper(res, nums, pos+1);
                swap(nums, i, pos);
            }
        }
    }
    
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    
}
