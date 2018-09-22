package general;

/*
Two images A and B are given, represented as binary, square matrices of the same size.
(A binary matrix has only 0s and 1s as values.)

We translate one image however we choose (sliding it left, right, up, or down any number of units),
and place it on top of the other image.
After, the overlap of this translation is the number of positions that have a 1 in both images.
(Note also that a translation does not include any kind of rotation.)
What is the largest possible overlap?

Example 1:
Input: A = [[1,1,0],
            [0,1,0],
            [0,1,0]]
       B = [[0,0,0],
            [0,1,1],
            [0,0,1]]
Output: 3
Explanation: We slide A to right by 1 unit and down by 1 unit.

Notes:
1 <= A.length = A[0].length = B.length = B[0].length <= 30
0 <= A[i][j], B[i][j] <= 1
 */
public class ImageOverlap_835 {
    // brute force O(n^4): n^2 possible start point (or dx dy pair), n^2 traverse for each
    public int largestOverlap(int[][] A, int[][] B) {
        int max=0;
        for (int x=0;x<A.length;++x){
            for (int y=0;y<A[0].length;++y){
                if (A[x][y]==1){
                    ++max;
                }
            }
        }

        int res=0, temp;
        for (int x=1-B.length;x<B.length;++x){
            for (int y=1-B[0].length;y<B[0].length;++y){
                temp = count(A,B,x,y);
                if (temp==max) return max;
                if (temp>res) res=temp;
            }
        }

        return res;
    }

    private int count(int[][] A, int[][] B, int dx, int dy){
        int count = 0, up, down, left, right;

        if (dx>0){
            up=0;
            down=B.length-dx;
        } else {
            up=-dx;
            down=B.length;
        }

        if (dy>0){
            left=0;
            right=B[0].length-dy;
        } else {
            left = -dy;
            right = B[0].length;
        }

        for (int x=up;x<down;++x){
            for (int y=left;y<right;++y){
                if (A[x][y]==1 && B[x+dx][y+dy]==1) ++count;
            }
        }
        return count;
    }
}
