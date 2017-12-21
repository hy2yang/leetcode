package search_sort;
/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.
Given target = 20, return false.
*/
public class Searcha2DMatrix2_240 {
    
    
    public boolean searchMatrix(int[][] a, int t) {                   // start from either bottom-left or top-right
        if( a==null || a.length<1 || a[0].length<1) return false;     // so that there will be one right direction to go
        int x=a.length, y=a[0].length;                    // if from top-left or bottom-right, both up and left are right directions(smaller)
        if (t>a[x-1][y-1] || t<a[0][0]) return false;
        
        int i=x-1,j=0;
        while (i>=0 && j<y) {
            if (a[i][j]<t) ++j;
            else if (a[i][j]>t) --i;
            else return true;
        }
        return false;
    }

}
