package onehundred;

import java.util.Arrays;

public class Search2DMatrix {
    // 11ms slow
    public boolean searchMatrix(int[][] a, int t) {
        if (a.length<1 || a[0].length<1) return false;
        int y=a.length;
        int x=a[0].length;
        
        for (int i=0;i<y;i++) {
            if (t<a[i][0]) return false;
            if (t>a[i][x-1]) continue;
            return (Arrays.binarySearch(a[i], t)>-1);
        }
        return false;
    }
    
    // hint: treat matrix as a normal array and use binary search;
    public boolean searchMatrixB(int[][] a, int t) {
        if (a.length<1 || a[0].length<1) return false;
        int y=a.length;
        int x=a[0].length;
        int lo=0,hi=x*y-1;
        while (lo<hi) {
            int mid=lo+(hi-lo)/2;            
            if (a[mid/x][mid%x]<t) lo=mid+1;
            else hi=mid;
        }
        return (a[hi/x][hi%x]==t);
    }
  // 13ms , slower??????
}
