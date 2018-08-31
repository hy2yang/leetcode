package bitManipulation;

/*
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
return 964176192 (represented in binary as 00111001011110000010100101000000).
*/

public class ReverseBits_190 {
    
    public int reverseBits(int n) {
        // front bit is sign: 1 for negative
        int res=0;
        for (int i=0;i<32;++i){
            res<<=1;
            res|=n&1;
            n>>=1; 
        }
        return res;
    }

}
