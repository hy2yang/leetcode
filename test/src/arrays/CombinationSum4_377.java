package arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an integer array with all positive numbers and no duplicates, 
find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?
*/
public class CombinationSum4_377 {

    public int combinationSum4(int[] nums, int target) {
        int[] n=Arrays.copyOf(nums,nums.length); 
        HashMap<Integer,Integer> map = new HashMap<>();
        return dfs(n,0,target, map);
    }
    
    private int dfs(int[] n, int sum, int target, HashMap<Integer,Integer> map){
        if (map.containsKey(sum)) return map.get(sum);
        if (sum>target) return 0;
        if (sum==target) return 1;
        int res=0;
        for (int i:n){
            res+=dfs(n,sum+i,target, map);
        }
        map.put(sum, res);
        return res;
    }
    
    
    public int combinationSum4_dp(int[] nums, int target) {   // recursive dp
        int[] dp =new int[target+1];
        Arrays.fill(dp, -1);
        dp[0]=1;        
        return dpHelper(dp, nums, target);
    }
    
    private int dpHelper(int[] dp, int[] nums, int target) {
        if (dp[target]!=-1) return dp[target];
        int res=0;
        for (int i=0;i<nums.length;++i) {
            if (nums[i]<=target) {
                res+=dpHelper(dp, nums, target-nums[i]);     // dp[x]= sum(dp[x-nums[i]) i from 0 to nums.length-1; 
            }                                                //             this means combinations when last number is nums[i]
        }
        dp[target]=res;
        return res;
    }
    
}
