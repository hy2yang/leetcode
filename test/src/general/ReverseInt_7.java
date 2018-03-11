package general;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output:  321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. 
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/
public class ReverseInt_7 {
    
    public int reverse(int x) {
        int copy=x;
        int tail=0,res=0;
        
        while (copy!=0){            
            tail=copy%10;
            copy/=10;
            if ( ((10*res+tail)-tail)/10 != res){    //check overfloat            
                return 0;
            }
            res=10*res+tail;            
        }
        return res;        
    }

}
