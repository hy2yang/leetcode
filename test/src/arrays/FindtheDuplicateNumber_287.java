package arrays;
/*
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
prove that at least one duplicate number must exist. 
Assume that there is only one duplicate number, find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
public class FindtheDuplicateNumber_287 {
    
    public int findDuplicate(int[] nums) {
        if (nums.length<2) return -1;
        int lo=nums[0],hi=nums[lo];
        while (lo!=hi) {
            lo=nums[lo];
            hi=nums[nums[hi]];
        }
        hi=0;
        while (lo!=hi) {
            lo=nums[lo];
            hi=nums[hi];
        }
        return lo;
    }

}
/*
Same as Linked List Cycle II. 
Use two pointers the fast and the slow. 
The fast one goes forward two steps each time, while  slow one step each time. 
They must meet the same int when slow==fast. 
They meet in a circle, the duplicate number must be the entry point of the circle when visiting the array from nums[0]. 
To find the entry point. We use a point to visit form begining with one step each time. 
When fast==slow, they meet at the entry point of the circle.
*/