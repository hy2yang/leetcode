package dp;
/*
Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot,
and two sightseeing spots i and j have distance j - i between them.

The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) :
the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

Example 1:
Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11

Note:
    2 <= A.length <= 50000
    1 <= A[i] <= 1000
 */
public class BestSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] A) {
        int res = 0;                                // result = A[i]+i +A[j]-j
        int max = 0;                                // max a[i]+i so far
        for (int i=0;i<A.length;++i){
            res = res>max+A[i]-i? res:max+A[i]-i;   // pick i as end or not
                                                    // update res first since cannot start and end at same point
            max = max>A[i]+i? max: A[i]+i;          // pick i as start or not
        }

        return res;
    }
}
