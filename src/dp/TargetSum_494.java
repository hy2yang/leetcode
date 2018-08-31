package dp;
/*
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. 
For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/
public class TargetSum_494 {
    
    // actual problem: devide nums into 2 subsets, Positive and Negetive
    // sum(P)-sum(N)= S, which is sum(P)+sum(P)= S+sum(all), sum(P)=(S+sum(all))/2
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum=0;
        for (int i:nums) sum+=i;
        
        if (sum<S || -sum>S) return 0;
        sum+=S;
        if (sum%2==1) return 0;  // if S+sum(all) is odd, there can not be such P since all numbers are int
        sum>>=1;
        
        int[] dp=new int[sum+1];
        dp[0]=1;
        for (int i:nums) {
            for (int j=sum;j>=i;--j) {  // if j<i -> current number>current sum, no help adding current number
                dp[j]+=dp[j-i];         // front part of dp[] (where j<i) needs no updating
            }
        }
        return dp[sum];
    }
    
    /*
    dp[i][j]: number of ways sum j can be reached from the first i numbers.
    Base case: dp[i][0] is 1; one way to get sum=0 : subset={};
    Transition function: dp[i][j] = dp[i-1][j]+dp[i-1][j-nums[i]];
    For each number, if we don’t pick it, there are dp[i-1][j] ways,
    If we pick it, we need to get number of ways to get j-nums[i] using i-1 numbers, which is dp[i-1][j-nums[i]].
    */

}
