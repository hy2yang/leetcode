package onehundred;

public class SingleNumberII {

    public static void main(String[] args) {


    }
    
    public int singleNumber(int[] nums) {  //count bits for every bit in int32
        int ans=0;
        for (int i=0;i<32;++i) {
            int sumbit=0;
            for (int j=0;j<nums.length;++j) {
                if (((nums[j]>>i)&1)==1) {
                    ++sumbit;
                    sumbit%=3;
                }                 
            }
            if (sumbit!=0) ans=ans|(sumbit<<i);
        }
        return ans;
    }

}
