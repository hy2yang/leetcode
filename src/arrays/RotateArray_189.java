package arrays;

//Rotate an array of n elements to the right by k steps.
//For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

public class RotateArray_189 {
    
    public void rotate(int[] nums, int k) {
        if (nums.length<2) return;
        int n=nums.length-1;
        k%=nums.length;        
        reverse(nums,0,n-k);
        reverse(nums,n-k+1,n);
        reverse(nums,0,n);
        
    }
    
    private void reverse(int[]n, int lo, int hi) {
        int temp;
        while (lo<hi) {
            temp=n[lo];
            n[lo++]=n[hi];
            n[hi--]=temp;
        }
    }

}
