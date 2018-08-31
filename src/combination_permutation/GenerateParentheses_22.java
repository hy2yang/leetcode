package combination_permutation;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/
public class GenerateParentheses_22 {
    
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        if (n==0) return res;
        char[] base=new char[2*n];
        generate(res,0,0,n,base);
        return res;
    }
    
    static void generate(List<String> res, int left, int right, int n, char[] base){
        if (left==n && right==n){
            res.add(new String(base));
            return;
        }
        
        if (left<n){
            base[left+right]='(';
            generate(res,left+1,right,n,base);
        }
        
        if (right<left){
            base[left+right]=')';
            generate(res,left,right+1,n,base);
        }
    }

}
