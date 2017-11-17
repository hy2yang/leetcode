package search_sort;

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

}
