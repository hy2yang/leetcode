package arrays;

import java.util.ArrayDeque;

/*
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Therefore, return the max sliding window as [3,3,5,5,6,7].

Note: 
You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
*/

public class SlidingWindowMaximum_239 {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums==null || k<1) return new int[0];        
        int[] res= new int[nums.length-k+1];
        int x=0;
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        
        for (int i=0;i<nums.length;++i) {
            while (!deque.isEmpty() && deque.peek()<i-k+1) deque.poll();                    // leave out left ones
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]) deque.pollLast();    // discard ones smaller than the current one 
            deque.offer(i);                                                                 // add current one
            if (i>=k-1) res[x++]=nums[deque.peek()];
        }
        return res;
    }

}
