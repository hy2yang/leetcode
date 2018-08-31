package combination_permutation;

import java.util.ArrayList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
public class Combinations_77 {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return res;
        }
        if (k == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        res = combine(n - 1, k - 1);
        for (List<Integer> i : res) {
            i.add(n);
        }
        res.addAll(combine(n - 1, k));
        return res;
    }

}
