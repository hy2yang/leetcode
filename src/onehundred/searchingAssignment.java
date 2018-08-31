package onehundred;
import java.util.Arrays;

public class searchingAssignment {

    public static void main(String[] args) {

        int[] i1={-85,14,35,-8,54,-71,26,79};
        System.out.println( findPeak(i1) );
        find2SumClosestTo0(i1);

    }
    
    //1. Find peak in an array
    
    static int findPeak(int[] a) {
        if (a[0]>=a[1]) return a[0];
        for (int i=1;i<a.length-2;i++) {
            if (a[1]>=a[i-1] && a[i]>=a[i+1]) return a[i];
        }
        if (a[a.length-1]>=a[a.length-2]) return a[a.length-1];
        return -1;
        // O(n) interate method, no optimization but works for special cases 
    }

    //2. Find Pair where sum is closest to 0
    static void find2SumClosestTo0(int[] a) {
        int[] copy=a.clone();
        Arrays.sort(copy);
        int lo=0;
        int hi=copy.length-1;
        int lo_close=0;
        int hi_close=copy.length-1;
        int diff =Integer.MAX_VALUE;
        int sum=0;
        while (lo<hi) {
            sum=copy[lo]+copy[hi];
            if(sum==0) break;
            if(Math.abs(sum)<diff) {
                lo_close=lo;
                hi_close=hi;
            }
            if (sum>0) hi--;
            if (sum<0) lo++;            
        }
        
        //lo_close=Arrays.asList(a).indexOf(copy[lo_close]);
        //hi_close=Arrays.asList(a).indexOf(copy[hi_close]);
        System.out.println("pair of which sum closest to 0 is "+copy[lo_close]+" and "+copy[hi_close]+".");
        
    }
    
    
}
