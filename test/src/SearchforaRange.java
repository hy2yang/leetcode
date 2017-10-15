import java.util.Arrays;


public class SearchforaRange {
    
    public static void main(String[] args) {
        int[] in ={1,5};
        System.out.println(searchRange(in,4)[0]+" "+searchRange(in,4)[1]);
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] range={-1,-1};        
        if (nums.length==0 || target<nums[0] || target>nums[nums.length-1]) return range;
        int s=Arrays.binarySearch(nums, 0, nums.length, target);
        if (s<=-1) return range;
        int l=s;
        int r=s;
        while (Arrays.binarySearch(nums, 0, l, target)>-1) {
            l=Arrays.binarySearch(nums, 0, l, target);
        }
        while (Arrays.binarySearch(nums, r+1, nums.length, target)>-1) {
            r=Arrays.binarySearch(nums, r+1, nums.length, target);
        }
        range[0]=l;
        range[1]=r;
        return range;
        
    }
}

// qiuck way range[0]=firstGreaterOrEqual(target) range[1]=firstGreaterOrEqual(target+1)
