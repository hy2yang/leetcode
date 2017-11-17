package search_sort;

public class Sqrt_69 {
    
    public int mySqrt(int x) {
        if (x==0) return 0;
        int lo=1,hi=x;
        int mid,res=0;
        while (lo<=hi) {
            mid=lo+(hi-lo)/2;            
            if (mid<=x/mid) {  // no mid*mid. may overfloat
                lo=mid+1;
                res=mid;
            }
            else {
                hi=mid-1;
            }
        }
        return res;
    }

}
