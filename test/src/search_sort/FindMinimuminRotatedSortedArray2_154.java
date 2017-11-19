package search_sort;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
*/

public class FindMinimuminRotatedSortedArray2_154 {
    
    public int findMin(int[] n) {
        int lo=0,hi=n.length-1;                
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            
            if(n[mid]<n[hi]) hi=mid;
            else if(n[mid]>n[hi]) lo=mid+1;
            else --hi;  // when num[mid] and num[hi] are same, we can cut one largest off and minimum remains unchanged
        }
        return n[lo];
    }

}
