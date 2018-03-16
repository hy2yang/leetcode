package bitManipulation;
/*
Given an array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class SingleNumber2_137 {
    
    public int singleNumber(int[] nums) {
        int[] bitCount= new int[32];
        int res=0;
        
        for (int i : nums){
            for (int j=0;j<32;++j){
                if ( ((i>>j)&1)==1 )  ++bitCount[j];
            }          
        }
        for (int i=0;i<32;++i) {
            if (bitCount[i]%3!=0){
                res|=(1<<i);
            }
        }
        return res;
    }

}
