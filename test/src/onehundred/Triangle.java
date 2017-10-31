package onehundred;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> t=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        a.add(-1);
        b.add(-2);
        b.add(-3);
        t.add(a);
        t.add(b);
        minimumTotal(t);

    }
    
    public static int minimumTotal(List<List<Integer>> t) {
        int n=t.size();
        int[] dp=new int[n];
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;++i) {
            for (int j=i;j>=0;--j) {
                if (j==0) dp[j]+=t.get(i).get(0);
                else if (j==i) dp[j]=dp[j-1]+t.get(i).get(j);
                else dp[j]=Math.min(dp[j], dp[j-1])+t.get(i).get(j);
                if (i==n-1) min=Math.min(min, dp[j]);
            }
        }
        return min;
    }

}
