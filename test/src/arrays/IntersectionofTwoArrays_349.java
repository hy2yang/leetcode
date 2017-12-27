package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class IntersectionofTwoArrays_349 {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();

        for (int i : nums1) {
            s.add(i);
        }

        List<Integer> t = new ArrayList<>();
        for (int i : nums2) {
            if (s.contains(i)) {
                t.add(i);
                s.remove(i);
            }
        }
        int[] res = new int[t.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = t.get(i);
        }
        return res;

    }

}
