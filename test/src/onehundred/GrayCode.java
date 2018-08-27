package onehundred;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
    }
    
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> res=new ArrayList<>();
        res.add(0);
        if (n==0) return res;
        for (int i=0;i<n;i++) {
            int x=res.size();
            for (int j=x-1;j>-1;j--) {    // first half remains the same (add 0 in front)
                int t=1<<i;               // t= 100..0 highest bit (ith bit) 1, followed by 0s
                res.add(res.get(j) | t);   // second half add 1 in front
            }
        }
        return res;
    }

}
