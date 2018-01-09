package arrays;
/*
A sequence of number is called arithmetic if it consists of at least three elements and if 
the difference between any two consecutive elements is the same.
For example, these are arithmetic sequence:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.
1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. 
A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:
A = [1, 2, 3, 4]
return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/
public class ArithmeticSlices_413 {
    
    public int numberOfArithmeticSlices(int[] a) {
        if (a==null || a.length<3) return 0;
        int res=0, cur=0;
        for (int i=2;i<a.length;++i) {
            if (a[i]-a[i-1] == a[i-1]-a[i-2]) {
                cur++;                         // if current slice length=x, when add 1 more number at end
                res+=cur;                      // new slices we get: 1 length=x+1, 1 length=x, 1 length=x-1... 1 length 3
            }                                  // sums to x+1-end+1, end=3, total x-1 new slices, here x=cur+2, so cur+1 new slices
            else cur=0;
        }
        return res;
    }

}
