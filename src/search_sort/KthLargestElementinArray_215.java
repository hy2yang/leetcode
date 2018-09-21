package search_sort;

public class KthLargestElementinArray_215 {
    
    public int findKthLargest(int[] a, int k) {
        int lo = 0, hi = a.length - 1;
        k=a.length-k;
        while (hi > lo)
        {
            int j = partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }
        return a[k];        
    }
    
    private void swap (int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    private int partition (int[] arr, int lo, int hi) {  // the same partition used in qucik sort
        int pivot=lo-1, pval = arr[hi];
        for (int i=lo;i<hi;++i){
            if (arr[i]<pval){
                swap(arr, ++pivot, i);
            }
        }
        swap(arr, ++pivot, hi);
        return pivot;
    }
    
}
