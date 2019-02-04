package general;
/*
Given two lists of closed intervals,
each list of intervals is pairwise disjoint and in sorted order.
Return the intersection of these two interval lists.
(Formally, a closed interval [a, b] (with a <= b) denotes the set of
real numbers x with a <= x <= b.
The intersection of two closed intervals is a set of real numbers that
is either empty, or can be represented as a closed interval.
For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

Example 1:

Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.

Note:
0 <= A.length < 1000
0 <= B.length < 1000
0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 */
import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections_986 {

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> li = new LinkedList<>();
        int pa = 0;
        int pb = 0;

        while (pa < A.length && pb < B.length) {
            int lo = Math.max(A[pa].start, B[pb].start);
            int hi = Math.min(A[pa].end, B[pb].end);
            if (lo <= hi) {
                li.add(new Interval(lo, hi));
            }

            if (hi == A[pa].end) ++pa;
            else ++pb;
        }

        return li.toArray(new Interval[0]);
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
