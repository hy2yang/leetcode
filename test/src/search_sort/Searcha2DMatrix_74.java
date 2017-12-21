package search_sort;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/
public class Searcha2DMatrix_74 {
    
    public boolean searchMatrix(int[][] a, int t) {
        if( a==null || a.length<1 || a[0].length<1) return false;
        int x=a.length, y=a[0].length;
        int lo=0,hi=x*y-1, mid, temp;
        if (t>a[x-1][y-1] || t<a[0][0]) return false;
        while (lo<=hi) {
            mid= lo+ ((hi-lo)>>1);
            temp=a[mid/y][mid%y];
            if ( temp==t ) return true;
            if ( temp>t ) hi=mid-1;
            else lo=mid+1;
        }
        return false;
    }
}

/*
public static int indexOf(int[] a, int key) {              // "standard" BinarySearch from algs4 priceton              
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else return mid;
    }
    return -1;
}
*/