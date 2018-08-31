package onehundred;

public class SearchinRotatedSortedArray2 {
    
    public static void main(String[] args) {

        int[] a= {3,1};
        System.out.println(search(a,1));

    }
    
    public static boolean search(int[] nums, int target) {        
        if (nums.length==0) return false;         
        int lo=0;
        int hi=nums.length-1;
        while (lo<=hi) {
            int mid=lo+(hi-lo)/2;
            if (nums[mid]==target) return true;
            if (nums[lo]==nums[mid] && nums[mid]==nums[hi]) {
                lo++;
                hi--;
            }
            else if (nums[lo]==nums[mid]) lo=mid+1;
            else if (nums[hi]==nums[mid]) hi=mid;
            else if (nums[lo]<nums[mid]) {
                if (target>=nums[lo] && target <=nums[mid]) hi=mid;
                else lo=mid+1;
            }
            else if (nums[hi]>nums[mid]) {
                if (target>=nums[mid] && target <=nums[hi]) lo=mid+1;
                else hi=mid;                
            }            
        }
        return false;     
    }

}
