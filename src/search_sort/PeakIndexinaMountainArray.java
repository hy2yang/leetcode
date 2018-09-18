package search_sort;

/*
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain,
return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

Example 1:
Input: [0,1,0]
Output: 1

Example 2:
Input: [0,2,1,0]
Output: 1

Note:
3 <= A.length <= 10000
0 <= A[i] <= 10^6
A is a mountain, as defined above.
 */
public class PeakIndexinaMountainArray {


    public int peakIndexInMountainArray_shorter(int[] A) {  //like binary search, but watch out comparision and A[mid-1]
        int lo=0, hi=A.length-1;
        int mid;
        while(lo<hi){
            mid = lo+(hi-lo)/2;
            if (A[mid]<A[mid+1]) lo=mid+1;
            else  hi = mid;
        }
        return lo;
    }

    public int peakIndexInMountainArray(int[] A) {  //like binary search, but watch out comparision and A[mid-1]
        int lo=0, hi=A.length-1;
        int mid, h;
        while(true){
            mid = lo+(hi-lo)/2;
            if (mid==0) return 1;
            h = A[mid];
            if (h>A[mid-1] && h>A[mid+1]) return mid;
            else if (h<A[mid+1]) lo=mid+1;
            else  hi = mid;
        }
    }

}
