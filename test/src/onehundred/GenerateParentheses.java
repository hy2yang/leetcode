package onehundred;
import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res=new ArrayList<String>();
        if (n==0) return res;
        char[] base=new char[2*n];
        generate(res,0,0,n,base);
        return res;
    }
    
    static void generate(ArrayList<String> res, int left, int right, int n, char[] base){
        if (left+right==2*n){
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
