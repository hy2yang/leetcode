package onehundred;

public class NextPermutation {
    
    public void nextPermutation(int[] nums) {
        if (nums.length<2) return;
        int a=-1;
        int b=-1;
        for (int i=nums.length-1;i>=1;i--) {
            if (nums[i-1]<nums[i]) {
                a=i-1;
                break;
            }
            if( i==1) {
                reverse(nums,0,nums.length-1);
                return;
            }
        }
        for (int i=nums.length-1;i>=0;i--) {
            if (nums[i]>nums[a]) {
                b=i;
                break;
            }
        }
        swap(nums,a,b);
        reverse(nums,a+1,nums.length-1);
        return;
        
    }
    
    static void reverse(int[] nums, int begin, int end) {
        int lo=begin;
        int hi=end;
        while (lo<hi) {
            swap(nums,lo,hi);
            lo++;
            hi--;
        }
    }
    
    static void swap(int[] nums, int front, int back) {
        int temp=nums[back];
        nums[back]=nums[front];
        nums[front]=temp;
        return;
    }

}
