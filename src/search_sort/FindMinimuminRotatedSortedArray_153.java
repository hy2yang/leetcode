package search_sort;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
*/

public class FindMinimuminRotatedSortedArray_153 {
    
    public int findMin(int[] n) {
        int lo=0,hi=n.length-1;                
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            if (n[lo]<=n[mid] && n[mid]<=n[hi]) return n[lo];
            if (n[lo]>n[mid]) {
                hi=mid;
                continue;
            }
            if (n[lo]>n[hi]) {
                lo=mid+1;
                continue;
            }            
        }
        return n[lo];
    }
    
    public int findMin2(int[] n) {
        int lo=0,hi=n.length-1;                
        while(lo<hi){
            int mid=lo+(hi-lo)/2;
            
            if(n[mid]<n[hi]) hi=mid;
            else lo=mid+1;
        }
        return n[lo];
    }

}
