package onehundred;
import java.util.*;

public class MergeIntervals {    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
     }
    
    public List<Interval> merge(List<Interval> l) {
        ArrayList<Interval> res=new ArrayList<>();
        if (l.size()<2) return l;
        Comparator<Interval> left=new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start-b.start;
            }
        };
        Collections.sort(l, left);        
        int lo=l.get(0).start;
        int hi=l.get(0).end;
        for (int i=1;i<l.size();i++) {
            if (l.get(i).start<=hi) {
                hi=Math.max(hi, l.get(i).end);
                continue;
            }
            
            if (l.get(i).start>hi) {
                res.add(new Interval(lo,hi));
                lo=l.get(i).start;
                hi=l.get(i).end;
            }
        }
        res.add(new Interval(lo,hi));
        return res;  
    }
    
    public List<Interval> merge2(List<Interval> l) {
        ArrayList<Interval> res=new ArrayList<>();
        if (l.size()<2) return l;
        int[] starts=new int[l.size()];
        int[] ends=new int[l.size()];
                
        for (int i=0;i<l.size();i++) {
            starts[i]=l.get(i).start;
            ends[i]=l.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        for (int i=0,j=0;i<starts.length;) {            
            while (j<starts.length-1 && ends[j]>=starts[j+1]) j++;
            res.add(new Interval(starts[i],ends[j]));
            i=++j;
        }
        return res;        
    }
}
