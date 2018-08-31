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
    
    public int largestRectangleArea(int[] heights) {        
        int[] stack = new int[heights.length+1];
        int p=-1;                          // array and a pointer as a mock stack
        int res=0,area,h;
        
        for (int i=0; i<=heights.length;++i) {
            int cur= i==heights.length? 0:heights[i];  // a dummy bar h=0 at the end to pop all remaining bars
            while (p>=0 && cur<heights[stack[p]]) { // if current is shorter, some higher rectangle must end before cur
                h = heights[stack[p--]];            // the end of h-heighted rectangle is i-1
                area = h * (p<0? i:i-1-stack[p]);   // stack[p] is index of the first shorter to left of h
                if (res<area) res = area;                        
            }
            stack[++p] = i; // push if current is no shorter, calculate when rectangle of cur height can't extend
        }               
        return res;
    }
    
    public int largestRectangleArea2(int[] h) {   // shorter version, harder to understand
        ArrayDeque<Integer> s=new ArrayDeque<>();
        int res=0,area;
        
        for (int i=0; i<=h.length;++i) {
            int hbound= i==h.length? 0:h[i];  // fake a dummy bar h=0 at the end, to pop all remaining bars to calculate
            while (!s.isEmpty() && hbound<=h[s.peek()]) {                
                area=h[s.pop()]* (s.isEmpty()? i:i-1-s.peek());  //  
                if (res<area) res=area;                        
            }
            s.push(i);
        }
               
        return res;
    }
    
    public int largestRectangleArea3(int[] h) {
        ArrayDeque<Integer> s=new ArrayDeque<>();
        int res=0,pre,area;
        int i=0;
        while (i<h.length) {
            if (!s.isEmpty() && h[i]<h[s.peek()]) {
                pre=s.pop();
                area=h[pre]* (s.isEmpty()? i:i-1-s.peek());  // s is empty -> pre is the first bar, width=(i-1)     +   1
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
    
    
    

}
