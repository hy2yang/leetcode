package general;
/*
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
*/

public class DiagonalTraverse_498 {
    
    public int[] findDiagonalOrder(int[][] m) {
        if (m.length<1 || m[0].length<1) return new int[0];
        int w = m.length, h = m[0].length;
        int[] res= new int[w*h];
        int pos = 0;
        for (int i=0;i<w+h-1;++i){
            int lo = Math.max(0,i-h+1);
            int hi = Math.min(i,w-1);
            if ( (i&1)==1 ){
                for (int x=lo;x<=hi;++x){
                res[pos++]=m[x][i-x];
                } 
            } else {
                for (int x=hi;x>=lo;--x){
                res[pos++]=m[x][i-x];
                } 
            }
                       
        }        
        return res;
    }

}
