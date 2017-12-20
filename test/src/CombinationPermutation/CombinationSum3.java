package CombinationPermutation;

import java.util.ArrayList;
import java.util.List;

/*
Find all possible combinations of k numbers that add up to a number n, 
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7
Output:
[[1,2,4]]

Example 2:

Input: k = 3, n = 9
Output:
[[1,2,6], [1,3,5], [2,3,4]]

*/
public class CombinationSum3 {
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k<1 || n<1) return new ArrayList<>();
        int[] wip =new int[k];
        List<List<Integer>> res=new ArrayList<>();
        combinationSum3( k, n,  0, wip, res);
        return res;
    }
    
    private void combinationSum3(int k, int n, int pos, int[] wip, List<List<Integer>> res) {
        if (n<0 || pos>k) return;
        if (pos==k) {
            if (n!=0) return;
            else {
                List<Integer> temp=new ArrayList<>();
                for (int i:wip) {
                    temp.add(i);
                }
                res.add(temp);
                return;
            }
        }
        
        for (int i= pos>0? wip[pos-1]+1:1 ; i<10;++i) {
            wip[pos]=i;
            combinationSum3(k, n-i, pos+1, wip, res);
        }
    }
    
    public List<List<Integer>> combinationSum(int k, int n) {
        if (k<1 || n<1) return new ArrayList<>();
        return combinationSum(k, n, 0);
    }
    
    private List<List<Integer>>  combinationSum(int k, int n, int start){   
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if (k<1) return res;
        for (int i=start+1;i<10;++i) {
            if (i<n) {
                for (List<Integer> wip:combinationSum(k-1, n-i, i)) {
                    wip.add(0, i);
                    res.add(wip);
                }
            }
            else if (i==n && k==1) {
                List<Integer> wip=new ArrayList<>();
                wip.add(i);
                res.add(wip);
            }
            else break;
        }
        return res;
    }
    
}
