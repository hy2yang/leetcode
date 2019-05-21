package general;
/*
In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the i-th domino, so that A[i] and B[i] swap values.
Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.



Example 1:

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation:
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2,
as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation:
In this case, it is not possible to rotate the dominoes to make one row of values equal.

Note:
    1 <= A[i], B[i] <= 6
    2 <= A.length == B.length <= 20000
 */
public class MinimumDominoRotationsForEqualRow_1007 {

    public int minDominoRotations(int[] A, int[] B) {
        boolean[] cand = new boolean[7];     // candidates 1~6, index 0 is not used
        for (int i=1;i<7;++i) cand[i]=true;

        int[] freqA = new int[7];
        int[] freqB = new int[7];

        for (int i=0;i<A.length;++i){
            ++freqA[A[i]];
            ++freqB[B[i]];
            for (int j=1;j<7;++j){
                if (cand[j] && A[i]!=j && B[i]!=j) cand[j] = false;
            }
        }

        int res = A.length;
        for (int i=1;i<7;++i){
            if (cand[i]){
                int temp = Math.min(A.length-freqA[i], B.length-freqB[i]);
                if (temp<res) res = temp;
            }
        }

        return res==A.length? -1:res;
    }

}
