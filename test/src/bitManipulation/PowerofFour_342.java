package bitManipulation;

public class PowerofFour_342 {
    
    public boolean isPowerOfFour(int num) {
        if (num<1) return false;
        int mask=0x55555555;
        return (num&(num-1))==0 && (num&mask)!=0;   // power of 4: positive, only one bit is 1, the bit is on odd position
    }   // get rid of the right most 1    // check if the 1 bit is on odd position

}
