package arrays;
/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
*/
public class MergeSortedArray_88 {

    public void merge(int[] a, int m, int[] b, int n) {  // going backwards so we don't need extra space
        int pa=m-1, pb=n-1, p=m+n-1;
        while (pa>=0 && pb>=0) {
            a[p--]= a[pa]<b[pb]? b[pb--]:a[pa--];
        }
        while (pb>=0) a[p--]=b[pb--];
    }
    
}
