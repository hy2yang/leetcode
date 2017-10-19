package onehundred;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length==0) return 0;
        int i=0;
        int j=0;
        while(i<nums.length) {
            j=i;
            if (nums[i]==val) {
                while (nums[j]==val) {
                    j++;
                    if (j>nums.length-1) return i;
                }                
                nums[i]=nums[j];
                nums[j]=val;
            }
            i++;
        }
        return i+1;
    }
    
    /*
    public int removeElement(int[] nums, int val) {
        if (nums.length==0) return 0;
        int i=0;
        int j=0;
        while(i<nums.length) {
            if (nums[i]!=val){
                nums[j]=nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
     */
    
}
