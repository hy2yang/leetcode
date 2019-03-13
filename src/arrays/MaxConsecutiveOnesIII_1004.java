package arrays;
/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
Return the length of the longest (contiguous) subarray that contains only 1s.

Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation:
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation:
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Note:
    1 <= A.length <= 20000
    0 <= K <= A.length
    A[i] is 0 or 1
 */
public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] A, int K) {
        int lo = 0;
        int hi = 0;
        int res = 0;
        while (lo+res<A.length){

            while (hi<A.length) {
                if (A[hi]==0){
                    if (K==0) break;
                    --K;
                }
                ++hi;
            }

            if (res<hi-lo) res = hi-lo;

            while(lo<hi && A[lo]==1) ++lo;
            ++K;
            ++lo;

        }
        return res;
    }

}
