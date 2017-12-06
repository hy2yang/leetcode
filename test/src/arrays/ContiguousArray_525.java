package arrays;

import java.util.HashMap;

/*Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.
*/
public class ContiguousArray_525 {
    
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer>  sum2Index =new HashMap<>(); 
        sum2Index.put(0, -1);
        int max=0,sum=0;        
        for (int i=0;i<nums.length;++i) {
            sum+= nums[i]==1? 1:-1;
            if (sum2Index.containsKey(sum)) {
                if (i-sum2Index.get(sum)>max) max=i-sum2Index.get(sum);      // not adding to map because we want the longest        
            }
            else sum2Index.put(sum, i);
        }
        return max;
    }    

}
