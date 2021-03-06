package general;

import java.util.HashSet;

/*A happy number is a number defined by the following process: 
Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/
public class HappyNumber_202 {
    
    public boolean isHappy(int n) {
        HashSet<Integer> sums=new HashSet<>();
        while (true) {
            int sum=0,d;
            while (n!=0) {
                d=n%10;
                n/=10;
                sum+=d*d;
            }
            if (sum==1) return true;
            if (!sums.add(sum)) return false;
            n=sum;
        }
    }

}
