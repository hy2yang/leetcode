package search_sort;
/*
Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which
we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input:
[[0,0,0,0],
[1,0,1,0],
[0,1,1,0],
[0,0,0,0]]
Output: 3
Explanation:
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.

Example 2:
Input:
[[0,1,1,0],
[0,0,1,0],
[0,0,1,0],
[0,0,0,0]]
Output: 0
Explanation:
All 1s are either on the boundary or can reach the boundary.

Note:
    1 <= A.length <= 500
    1 <= A[i].length <= 500
    0 <= A[i][j] <= 1
    All rows have the same size.
 */
public class NumberofEnclaves_1020 {

    public int numEnclaves(int[][] A) {
        for (int i=0;i<A.length;++i){
            for (int j=0;j<A[0].length;){
                if (A[i][j]==1){
                    floodFill(A, i, j);
                }
                j+= (i==0||i==A.length-1)? 1:A[0].length-1;  //traverse only the border
            }
        }
        int res = 0;
        for (int i=0;i<A.length;++i){
            for (int j=0;j<A[0].length;++j){
                if (A[i][j]>0){
                    ++res;                // number of squares, not islands
                }
            }
        }

        return res;
    }

    private void floodFill(int[][] A, int x, int y){
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};

        A[x][y]=-1;

        for (int i=0;i<4;++i){
            int newx = x+dx[i];
            int newy = y+dy[i];
            if (newx>=0 && newy>=0 && newx<A.length && newy<A[0].length){
                if (A[newx][newy]==1){
                    floodFill(A, newx, newy);
                }
            }
        }
    }

}
