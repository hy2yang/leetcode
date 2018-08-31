package dp;

//Given a non-empty array containing only positive integers, find if 
//the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//Each of the array element will not exceed 100.
//The array size will not exceed 200.

public class PartitionEqualSubsetSum_416 {
    
    public boolean canPartition(int[] arr) {
        if (arr==null || arr.length==0) return true;
        int sum=0;
        for (int x: arr) {
            sum+=x;
        }
        if (sum%2==1) return false;
        sum/=2;
        //Arrays.sort(arr); no need to sort
        
        boolean[] dp=new boolean[1+sum];
        dp[0]=true;
        for (int i:arr) {
            for (int j=sum;j>=i;--j) {    // j from sum to i, if j<i -> current number>target sum, no help adding current number
                dp[j]= dp[j] || dp[j-i];  // so ignore current number and front part of dp[] needs no updating
            }
        }
        return dp[sum];
    }
    /*
    dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
    Base case: dp[0][0] is true;
    Transition function: dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
    For each number, if we don’t pick it, dp[i][j] = dp[i-1][j],
    If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]].
    */
}
