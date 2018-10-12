package intervals;

import java.util.LinkedList;
import java.util.List;
/*
Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval_57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int lo = newInterval.start;
        int hi = newInterval.end;


        int smaller=0;
        for (Interval i: intervals){
            if (i.end<lo) {
                res.add(i);
                ++smaller;
            }
            else if(i.start>hi){
                res.add(i);
            }
            else {
                if (i.start<lo) lo = i.start;
                if (i.end>hi) hi = i.end;
            }
        }

        res.add(smaller, new Interval(lo,hi));
        return res;
    }
}
