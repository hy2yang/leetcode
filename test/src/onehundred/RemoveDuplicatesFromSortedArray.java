package onehundred;

public class RemoveDuplicatesFromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        if (nums.length<2) return nums.length;
        int j=1;
        int i=0;
        for(j=1; j<nums.length;j++) {
            if (nums[j]==nums[j-1]) continue;
            i++;
            nums[i]=nums[j];
        }
        return i+1;
    }
    
}
