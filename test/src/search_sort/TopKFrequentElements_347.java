package search_sort;
/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note: 
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements_347 {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> m=new HashMap<>();              // (number,frequency)
        List<Integer>[] bucket=new List[nums.length+1];
        
        for (int i:nums) {
            m.put(i, m.getOrDefault(i, 0)+1);            
        }
        
        for (int i:m.keySet()) {
            int f=m.get(i);
            if (bucket[f]==null) bucket[f]=new ArrayList<Integer>();  
            bucket[f].add(i);           // put numbers into buckets by different frequencies
        }
        
        List<Integer> res=new ArrayList<>();
        
        for (int pos=nums.length; res.size()<k && pos>=0 ; --pos) { // get numbers with highest frequencies into result
            if (bucket[pos]!=null) {
                res.addAll(bucket[pos]);
            }
        }
        
        return res;
    }

}
