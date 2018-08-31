package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
public class IntersectionofTwoArrays2 {
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Map<Integer,Integer> m = new HashMap<>();
        for (int i : nums1) {
            m.put(i,m.getOrDefault(i, 0)+1);
        }

        List<Integer> t = new ArrayList<>();
        for (int i : nums2) {
            if (m.containsKey(i) && m.get(i)>0) {
                t.add(i);                
                m.put(i, m.get(i)-1);
            }
        }
        int[] res = new int[t.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = t.get(i);
        }
        
        return res;
    }

}
