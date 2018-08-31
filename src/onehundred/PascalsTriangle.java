package onehundred;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        generate(5);

    }
    
    public static List<List<Integer>> generate(int n) {
        ArrayList<List<Integer>> res= new ArrayList<>();
        if (n<1) return res;
        res.add(new ArrayList<Integer>());
        res.get(0).add(1);
        for (int i=2;i<=n;++i) {
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(1);
            int j=1;
            while (temp.size()<i-1) {                
                temp.add(res.get(i-2).get(j-1)+res.get(i-2).get(j));
                ++j;
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
    
    public static List<List<Integer>> DPgenerate(int n) {
        ArrayList<List<Integer>> res= new ArrayList<>();
        if (n<1) return res;
        ArrayList<Integer> pre = null,cur=null;
        for (int i=0;i<n;++i) {
            cur=new ArrayList<>();
            for (int j=0;j<=i;++j) {
                if (j==0||j==i) cur.add(1);
                else cur.add(pre.get(j-1)+pre.get(j));
            }
            pre=cur;
            res.add(cur);
        }
        return res;        
    }

}
