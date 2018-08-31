package general;
/*
Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. 
Return the maximum valued number you could get.

Example 1:
Input: 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:
Input: 9973
Output: 9973
Explanation: No swap.
Note:
The given number is in the range [0, 108]
*/
public class MaximumSwap_670 {

    public int maximumSwap(int num) {
        char[] cs=Integer.toString(num).toCharArray();
        int max=-1,maxpos=-1;
        int left=-1,right=-1;        
        
        for (int i=cs.length-1;i>=0;--i) {
            if (cs[i]>max) {
                max=cs[i];
                maxpos=i;
            }
            else if (cs[i]<max){
                left=i;
                right=maxpos;
            }
        }
        
        if (left==-1) return num;
        
        char temp=cs[left];
        cs[left]=cs[right];
        cs[right]=temp;        
        return Integer.parseInt(new String(cs));
    }
    
}
