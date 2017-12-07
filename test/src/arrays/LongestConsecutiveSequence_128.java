package arrays;

import java.util.HashMap;
import java.util.HashSet;

/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
public class LongestConsecutiveSequence_128 {
    
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }
        int n, res=0;
        for (int i:set) {
            if (!set.contains(i-1)){
                n=i+1;
                while (set.contains(n)) ++n; 
                if (n-i>res) res=n-i;
            }
        }
        return res;
    }
    
    public int longestConsecutive2(int[] nums) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();  // number - the length of longest consecutive it's in
        int left,right,len;                            // but only leftmost and rightost values are updated as longest
        for (Integer i:nums) {
            if (!map.containsKey(i)) {
                left= map.containsKey(i-1)? map.get(i-1):0;
                right= map.containsKey(i+1)? map.get(i+1):0;
                len=left+1+right;
                map.put(i, len);
                map.put(i-left, len);
                map.put(i+right, len);
                if (len>res) res=len;
            }            
        }
        return res;
    } 
}
