package arrays;

import java.util.HashSet;

public class ContainsDuplicate2_219 {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> h=new HashSet<>();
        for (int i=0;i<nums.length;++i){
            if (h.size()>k) h.remove(nums[i-k-1]);    // nums[i] is not added yet, so kth element before is at i-k-1
            if (!h.add(nums[i])) return true;         //add() returns true if this set did not already contain the specified element   
        }
        return false;
    }

}
