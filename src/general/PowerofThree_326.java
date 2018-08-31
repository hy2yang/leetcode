package general;
/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
*/
public class PowerofThree_326 {

    public boolean isPowerOfThree(int n) {
        if (n<1) return false;
        return ( 1162261467%n ==0);  // 1162261467=2^19 is the largest power of 3 in 32-bit int
    }                                // log3((2^31)-1)=log(2,147,483,647)/log(3) = 19.55882.....
    
}
