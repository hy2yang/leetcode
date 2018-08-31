package onehundred;

public class SingleNumber {
    
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i:nums) {
            res^=i;
        }
        return res;
    }
    // ⊕ Exclusive Or (XOR), bit manipulation ^ in java
    // X⊕0 = X , X⊕X = 0
    // ⊕ has Commutative property, Associative property
    // so A⊕B⊕A = B⊕0 = B
}
