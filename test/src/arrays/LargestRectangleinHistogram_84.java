package arrays;

import java.util.ArrayDeque;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
*/


public class LargestRectangleinHistogram_84 {
    
    public int largestRectangleArea(int[] h) {
        ArrayDeque<Integer> s=new ArrayDeque<>();
        int res=0,pre,area;
        int i=0;
        while (i<h.length) {
            if (!s.isEmpty() && h[i]<h[s.peek()]) {
                pre=s.pop();
                area=h[pre]* (s.isEmpty()? i:i-s.peek()-1);  // s is empty -> pre is the first bar, width=(i-1)     +   1
                if (res<area) res=area;                      //                                        index of pre   index start at 0
            }
            else s.push(i++);            
        }
        
        while(!s.isEmpty()) {
            pre=s.pop();
            area=h[pre]* (s.isEmpty()? i:i-s.peek()-1);
            if (res<area) res=area;
        }        
        return res;
    }
    
    public int largestRectangleArea2(int[] h) {   // shorter version, harder to understand
        ArrayDeque<Integer> s=new ArrayDeque<>();
        int res=0,area;
        
        for (int i=0; i<=h.length;++i) {
            int hbound= i==h.length? 0:h[i];  // fake a dummy bar h=0 at the end, to pop all remaining bars to calculate
            while (!s.isEmpty() && hbound<=h[s.peek()]) {                
                area=h[s.pop()]* (s.isEmpty()? i:i-s.peek()-1);
                if (res<area) res=area;                        
            }
            s.push(i);
        }
               
        return res;
    }
    

}
