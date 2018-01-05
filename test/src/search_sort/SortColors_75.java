package search_sort;
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/
public class SortColors_75 {
    
    public void sortColors(int[] nums) {
        int lo=0,hi=nums.length-1;
        int p=0;
        while (p<hi) {
            if (nums[p]==0) swap(nums, lo++,p++);  
            else if (nums[p]==2) swap(nums,hi--,p);  // hi swaped to p, hi is unprocessed, so do not move p yet
            else ++p;
        } 
    }
    
    private void swap(int[] a, int i, int j) {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public void sortColors_count(int[] nums) {  // two-pass
        int r=0,w=0,b=0;
        for (int i:nums) {
            if (i==0) ++r;
            else if (i==1) ++w;
            else ++b;
        }
        
        int i=0;
        while (i<nums.length){
            if (r>0) {
                nums[i++]=0;
                --r;
            }
            else if (w>0) {
                nums[i++]=1;
                --w;
            }
            else if (b>0) {
                nums[i++]=2;
                --b;
            }
        }
    }
    
}
