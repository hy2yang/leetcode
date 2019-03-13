package general;

import java.util.Arrays;

/*
Given an array A of integers, we must modify the array in the following way:
we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
(We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.


Example 1:
Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].

Example 2:
Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].

Example 3:
Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].

Note:
    1 <= A.length <= 10000
    1 <= K <= 10000
    -100 <= A[i] <= 100
 */
public class MaximizeSumOfArrayAfterKNegations_1005 {

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int p=0;
        while (p<A.length && A[p]<0 && K>0){
            A[p] = -A[p];
            ++p;
            --K;
        }
        if (p>0) K= K%(2*p);  // flip all initial negative (now positive) numbers twice

        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i: A){
            if (i<min) min = i;
            res+=i;
        }

        return res-(K%2)*2*min;  // all the K left, flip the number with least absolute val
    }

}
