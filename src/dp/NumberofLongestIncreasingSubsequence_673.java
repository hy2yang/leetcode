package dp;
/*
Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
*/

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence_673 {

    public int findNumberOfLIS(int[] nums) {
        if (nums==null || nums.length<1) return 0;
        int[] len=new int[nums.length];              // length of LIS end here
        int[] count=new int[nums.length];            // number of LIS end here
                                                     // claculate 2 dp arrays increasingly
        Arrays.fill(len,1);
        Arrays.fill(count,1);
        int maxlen=1, res=0;        
        for (int i=1;i<nums.length;++i) {
            for (int j=0;j<i;++j) {                  // len[j] count[j] are calculated before i
                if (nums[i]>nums[j]) {
                    if (len[j]+1==len[i]) count[i]+=count[j];
                    else if (len[j]+1>len[i]) {     // new LIS found, reset count, update len
                        count[i]=count[j];
                        len[i]=len[j]+1;
                        if (len[i]>maxlen) maxlen=len[i];
                    }
                }
            }
        }
        
        for (int i=0;i<len.length;++i) {
            if (len[i]==maxlen) res+=count[i];
        }
        return res;
    }
    
}
