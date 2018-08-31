package onehundred;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {


    }
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;
        int leftside= (nums[0]<=target)? 1:0;         
        int lo=0;
        int hi=nums.length;
        int midnum;
        while (lo<hi) {
            int mid=lo+(hi-lo)/2;
            if (leftside==1) {
                if (nums[mid]<nums[0]) midnum=target+1;
                else midnum=nums[mid];
            }
            else {
                if (nums[mid]>nums[nums.length-1]) midnum=target-1;
                else midnum=nums[mid];                
            }
            if (nums[mid]==target) return mid;
            if (midnum<target) lo=mid+1;
            else hi=mid;
        }
        return -1;
    }

}
