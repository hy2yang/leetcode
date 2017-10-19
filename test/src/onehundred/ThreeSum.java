package onehundred;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new LinkedList<>();
        if (nums.length<3) return result;
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++) {
            if(i>0 && nums[i-1]==nums[i]) continue;
            for (int j=i+1;j<nums.length;j++) {
                if(j>i+1 && nums[j-1]==nums[j]) continue;
                if (Arrays.binarySearch(nums, j+1, nums.length, -(nums[i]+nums[j]))>-1) {                    
                    int find=Arrays.binarySearch(nums,-(nums[i]+nums[j]));
                    result.add(Arrays.asList(nums[i],nums[j],nums[find]));
                }
            }
        }
        return result;
    }

}
