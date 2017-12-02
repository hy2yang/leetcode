package bitManipulation;

/*Given a range [m, n] where 0 <= m <= n <= 2147483647, 
return the bitwise AND of all numbers in this range, inclusive.
For example, given the range [5, 7], you should return 4.
*/
public class BitwiseANDofNumbersRange_201 {
    
    public int rangeBitwiseAnd(int m, int n) {
        int moved=0;
        while (n!=m) {
            n>>=1;
            m>>=1;
            ++moved;
        }
        return m<<moved;
    }
    
    /*  The idea is very simple:
        last bit of (odd number & even number) is 0.
        when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
        Move m and n rigth a position.
        Keep doing step 1,2,3 until m equal to n, left shift what's left in m by steps moved
     */
}
