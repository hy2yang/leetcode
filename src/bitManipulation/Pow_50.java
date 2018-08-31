package bitManipulation;
/*
Implement pow(x, n).

Example 1:
Input: 2.00000, 10
Output: 1024.00000

Example 2:
Input: 2.10000, 3
Output: 9.26100
*/
public class Pow_50 {
    
    public double myPow(double x, int n) {
        if (n==0 || x==1.0) return 1;        
        double res=1;
        long temp= n<0? -(long)n:(long)n;  // prevent overfloat
        while (temp>0) {
            if ((temp&1)!=0) res*=x;
            x*=x;
            temp>>=1;
        }
        return n<0? 1.0/res:res;
    }

}
