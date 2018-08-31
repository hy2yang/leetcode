package bitManipulation;

/*
find the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2
Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
Note:
Elements of the given array are in the range of 0 to 10^9
Length of the array will not exceed 10^4.
*/

public class TotalHammingDistance_477 {
    
    public int totalHammingDistance(int[] nums) {
        int n=nums.length;
        int res=0;
        int lastbit;
        for (int i=0;i<32;++i) {
            lastbit=0;
            for (int j=0;j<n;++j) {
                lastbit+=(nums[j]>>i)&1;                
            }
            res+=(n-lastbit)*lastbit;
        }
        return res;
    }
    
    /*
     *  sum number of 1s in last bit
     *  Consider you have 10 numbers and only one of them is a 1 the rest are zeros. How many (1, 0) pairs can you make? 
     *  Clearly you can make 9, pair the 1 with each of the other 9 zeros. 
     *  If you have 2 ones, you can pair each of those with the other 8 zeros giving 2*8 = 16. 
     *  you can pair each 1 with each zero so the number of pairs is just the number of 1's times the number of 0's. 
     */

}
