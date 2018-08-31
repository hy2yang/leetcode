package onehundred;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {

    }
    //backtracking 60ms, a bit slow
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> res=new ArrayList<List<Integer>>();
        if (n<1 || k<1) return res;
        List<Integer> wip=new ArrayList<Integer>();
        helper(res,wip,n,k,1);
        return res;
        
    }
    
    static void helper(ArrayList<List<Integer>> res, List<Integer> wip, int n, int k, int pos) {
        if (wip.size()==k) {
            res.add(new ArrayList<Integer>(wip));
            return;
        }        
        for (int i=pos;i<=n;i++) {
            if (!wip.contains(i)) {
                wip.add(i);
                helper(res,wip,n,k,i+1);
                wip.remove(wip.size()-1);
            }
        }
    }    
    
    // DP hint: C(n,k)=C(n-1,k-1)+C(n-1,k)

}
