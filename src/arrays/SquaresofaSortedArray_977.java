package arrays;

/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number,
also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Note:
    1 <= A.length <= 10000
    -10000 <= A[i] <= 10000
    A is sorted in non-decreasing order.
 */

public class SquaresofaSortedArray_977 {

    public int[] sortedSquares(int[] A) {

        for (int i=0;i<A.length;++i){
            A[i]*=A[i];
        }

        int[] res = new int[A.length];
        int lo=0;
        int hi=A.length-1;
        int p=res.length-1;

        while(lo<=hi){
            res[p--] = A[lo]<A[hi]? A[hi--]:A[lo++];
        }

        return res;

    }

    // simpler ver: fill res with A^2 then sort res, O(nlogn) time complexity
}
