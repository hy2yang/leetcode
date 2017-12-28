package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a set of distinct positive integers, find the largest subset such that 
every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:
nums: [1,2,3]
Result: [1,2] (of course, [1,3] will also be ok)

Example 2:
nums: [1,2,4,8]
Result: [1,2,4,8]
*/
public class LargestDivisibleSubset_368 {  
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if (nums==null || nums.length<1) return res;
        
        Arrays.sort(nums);
        int[] dp = new int[nums.length];      // dp[i]-> max length of set considering nums[0] to nums[i], inclusive
        dp[0] = 1;
        int maxPos=0;
        
        for (int i=1;i<nums.length;++i) {
            dp[i]=1;                         // initialized as 1: contains only self
            for (int j=i-1;j>-1;--j) {
                if (nums[i]%nums[j]==0 && dp[i]<dp[j]+1) dp[i]=dp[j]+1; // build path, j's path length +1 (put i in)                
            }
            if (dp[i]>dp[maxPos]) maxPos=i;  // record of index of the largest set
        }
        
        int length=dp[maxPos];
        for (int i=maxPos;i>-1;--i) {
            if ( dp[i]==length && nums[maxPos]%nums[i]==0 ) {    // keep on the right (longest) path
                res.add(nums[i]);
                --length;
            }
        }
        
        return res;
    }
    
    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<Integer> res=new ArrayList<>();
        if (nums==null || nums.length<1) return res;
        
        Arrays.sort(nums);
        List<Integer>[] dp = new ArrayList[nums.length];
        
        for (int i=0;i<nums.length;++i) {
            dp[i]= new ArrayList<Integer>();
            dp[i].add(nums[i]);
            int longest=-1, length=0;
            
            for (int j=0;j<i;++j) {
                if (nums[i]%nums[j]==0 && dp[j].size()>length) {
                    length=dp[j].size();
                    longest=j;
                }
            }
            if (longest>-1) dp[i].addAll(dp[longest]);            
        }
        
        int longest=0;
        for (int i=0;i<dp.length;++i) {
            if (dp[i].size()>dp[longest].size()) {
                longest=i;                
            }
        }        
        return dp[longest];
    }
   
}
