package general;
/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.
For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:
Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

Notes:
1 <= A.length = A[0].length <= 20
0 <= A[i][j] <= 1

 */
public class FlippinganImage_832 {

    public int[][] flipAndInvertImage(int[][] A) {
        int lo, hi;
        for (int x =0;x<A.length;++x){
            lo = 0;
            hi = A[x].length-1;
            while(lo<hi){
                if (A[x][lo]==A[x][hi]) {             // no need for actual swap: think about the cases
                    A[x][lo] = A[x][lo]==0? 1:0;
                    A[x][hi] = A[x][hi]==0? 1:0;
                }
                ++lo;
                --hi;
            }
            if (lo==hi) A[x][lo]= A[x][lo]==0? 1:0;
        }
        return A;
    }
}
