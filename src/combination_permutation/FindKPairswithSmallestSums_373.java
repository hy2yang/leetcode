package combination_permutation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
Return: [1,2],[1,4],[1,6]
The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
        
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
Return: [1,1],[1,1]
The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
        
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 
Return: [1,3],[2,3]
All possible pairs are returned from the sequence:
[1,3],[2,3]
*/
public class FindKPairswithSmallestSums_373 {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {   
        List<int[]> res=new ArrayList<>();
        if (nums1.length==0 || nums2.length==0 || k==0) return res;
        PriorityQueue<int[]> pq=new PriorityQueue<>(k, new pairComparator());
        for (int i=0;i<nums1.length;++i) {
            pq.offer(new int[] {nums1[i],nums2[0],0});  // nums1, nums2, index2       
        }
        int[] temp;
        while (k>0 && !pq.isEmpty()) {
           temp=pq.poll();
           res.add(new int[]{temp[0],temp[1]});
           --k;                                   // for each polled pair, put new pair with index2 increased
           if (temp[2]<nums2.length) pq.offer(new int[] {temp[0],nums2[temp[2]+1],temp[2]+1});
        }        
        return res;
    }
    // For every int in nums1, its partner to min sum strats from nums2[0]; 
    // for a int in nums1, its next partner sould be nums1[this] + nums2[old partner+1], unless out of boundary
    
    private class pairComparator implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {        
        return o1[0]+o1[1]-o2[0]-o2[1];
        }
    
    }

}
