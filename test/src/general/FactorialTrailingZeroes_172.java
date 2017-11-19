package general;

/*
Given an integer n, return the number of trailing zeroes in n!.
Note: Your solution should be in logarithmic time complexity.
*/

public class FactorialTrailingZeroes_172 {
    
    public int trailingZeroes(int n) {
        int res=0;
        while (n!=0) {
            n/=5;
            res+=n;
        }
        return res;
    }

}
