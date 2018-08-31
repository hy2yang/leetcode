package search_sort;
/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix =  [
          [ 1,  5,  9],
          [10, 11, 13],
          [12, 13, 15]
                      ],
k = 8,
return 13.
        
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

public class KthSmallestElementinaSortedMatrix_378 {

    public int kthSmallest(int[][] m, int k) {   // binary search
        int n=m.length;
        int lo=m[0][0],hi=m[n-1][n-1], mid, count, midinM ; // mid: calculated mid, count: numbers of int<=mid
        while (lo<hi) {                                     // midinM: smallest int>mid in matrix
            mid=lo+(hi-lo)/2;
            count=0;
            midinM=Integer.MAX_VALUE;
            int i=0, j=n-1;
            while (i<n && j>=0){                            // same as Search2DMatrix2_240
                if (m[i][j]>mid) {                          // start from top-right or bottom-left
                     if (m[i][j]<midinM) midinM=m[i][j];
                     --j;
                }
                else {
                    count+=j+1;                             // add number of int<mid in this row
                    ++i;
                }
            }
            if (count==k-1) return midinM;
            else if (count<k) lo=midinM;                         // numbers of int<=mid not enough
            else hi=mid;
        }
        return lo; 
    }
    
}
