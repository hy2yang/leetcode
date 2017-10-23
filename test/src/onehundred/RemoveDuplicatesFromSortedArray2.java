package onehundred;

public class RemoveDuplicatesFromSortedArray2 {
    
    public static void main(String[] args) {
        int[] a= {1,1,1};
        System.out.println(removeDuplicates(a));
    }
    
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length<2) return nums.length;
        int j=0;
        int i=0;
        for(j=0; j<nums.length;j++) {
            if (j>0 && nums[j]==nums[j-1]) continue;
            nums[i++]=nums[j];
            if(j+1<nums.length && nums[j]==nums[j+1]) nums[i++]=nums[++j];
        }
        return i;
    }   
}
