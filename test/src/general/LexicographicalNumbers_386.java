package general;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return 1 - n in lexicographical order.

For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].

Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
*/
public class LexicographicalNumbers_386 {

    public List<Integer> lexicalOrder(int n) {     // dfs, see numbers as a tree, then do a pre-order travelsal
        List<Integer> res= new ArrayList<>();      //    1        2        3    ...
                                                   //   /|\      /|\      /|\
                                                   // 10...19  20...29  30...39   ....
        for (int i=1;i<=9;++i) {
            helper(res, i, n);
        }        
        return res;
    }
    
    private void helper (List<Integer> res, int cur, int end) {
        if (cur>end) return;
        res.add(cur);
        cur*=10;
        for (int i=0;i<10;++i) {
            if (cur+i>end) return;
            helper(res,cur+i,end);
        }
    }
    
}
