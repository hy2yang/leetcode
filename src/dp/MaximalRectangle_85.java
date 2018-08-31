package dp;

import java.util.Arrays;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/
public class MaximalRectangle_85 {
    
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int x = matrix.length, y = matrix[0].length;
        int[] height = new int[y], left = new int[y], right = new int[y];
        Arrays.fill(right, y - 1);
        int rowleft, rowright, max = 0;

        for (int i = 0; i < x; ++i) {

            rowleft = 0;
            rowright = y - 1;

            for (int j = 0; j < y; ++j) {
                if (matrix[i][j] == '1') {
                    ++height[j]; // number of 1s above
                    left[j] = Math.max(left[j], rowleft); // left border of the rectangle containing this 1, left=0
                                                          // means no 1 has appeared

                } else {
                    height[j] = 0;
                    left[j] = 0;
                    rowleft = j + 1;

                }
            }

            for (int j = y - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {                    
                    right[j] = Math.min(right[j], rowright); // right border of the rectangle containing this 1, right=y-1 means no 1 on the right
                } else {
                    rowright = j - 1;
                    right[j] = y - 1;
                }
            }

            int cur;
            for (int j = 0; j < y; ++j) {
                cur = (right[j] - left[j] + 1) * height[j];
                if (cur > max)
                    max = cur;
            }

        }

        return max;
    }
    
    public static void main(String[] args) {
        char[][] m ={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalRectangle(m));
    }

}
