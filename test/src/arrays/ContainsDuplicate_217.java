package arrays;

import java.util.HashSet;

public class ContainsDuplicate_217 {
    
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> h=new HashSet<>();
        for (Integer i:nums){
            if (!h.add(i)) return true;         //add() returns true if this set did not already contain the specified element   
        }
        return false;
    }

}
