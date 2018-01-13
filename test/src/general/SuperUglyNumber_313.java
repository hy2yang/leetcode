package general;
/*
Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. 
For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers 
given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
*/
public class SuperUglyNumber_313 {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] res=new int[n];
        int[] count=new int[primes.length];
        res[0]=1;
        for (int i=1;i<n;++i) {
            res[i]=Integer.MAX_VALUE;
            
            for (int j=0;j<count.length;++j) {
                res[i]=Math.min(res[i], primes[j]*res[count[j]]);
            }
            for (int j=0;j<count.length;++j) {
               if (res[i]==primes[j]*res[count[j]]) ++count[j];  // can not break, eg. 6=3*2
            }
        }        
        return res[n-1];
    }

}
