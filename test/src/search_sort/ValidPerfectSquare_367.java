package search_sort;
/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.

Input: 16
Returns: True

Input: 14
Returns: False
*/

public class ValidPerfectSquare_367 {
    
    public boolean isPerfectSquare(int num) {
        if (num<=0) return false;
        int lo=1,hi=num;
        long mid;                             // use long to prevent mid*mid overflow
        while (lo<=hi) {
            mid=lo+(hi-lo)/2;
            if (mid*mid>num) hi=(int) (mid-1);
            else if (mid*mid<num) lo=(int) (mid+1);
            else return true;
        }
        return false;
    }

}
