package onehundred;
import java.util.*;

public class FourSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a= {-1,0,-5,-2,-2,-4,0,1,-2};
        System.out.print(fourSum(a,-9));

    }
    
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result= new ArrayList<>();
        if (nums.length<4) return result;
        Arrays.sort(nums);
        if ( 4*nums[0]>target || 4*nums[nums.length-1]<target) return result;
        for (int i=0;i<nums.length;i++) {
            int x=nums[i];
            if (i>0 && x==nums[i-1]) continue;
            if (x+3*nums[nums.length-1]<target) continue;
            if (4*x>target)break;
            if (4*x==target && i+3<nums.length &&x==nums[i+3]) {
                result.add(Arrays.asList(x,x,x,x));
                break;
            }
            findOther3(nums, target-x, result, i+1, x);
        }
        return result;
    }

    
    static void findOther3(int[] nums, int target, ArrayList<List<Integer>> result, int start, int firstfound ) {
        if (nums.length-start+1<3) return;
        if (3*nums[start]>target) return ;
        for (int i=start;i<nums.length;i++) {
            int x=nums[i];
            if (i>start && x==nums[i-1]) continue;
            if (x+2*nums[nums.length-1]<target) continue;
            if (3*x>target)break;
            if (3*x==target && i+2<nums.length &&x==nums[i+2]) {
                result.add(Arrays.asList(firstfound,x,x,x));
                break;
            }
            findOther2(nums, target-x, result, i+1, firstfound, x);
        }
    }
    
    static void findOther2 (int[] nums, int target, ArrayList<List<Integer>> result, int start, int firstfound,int secondfound ) {
        if (nums.length-start+1<2) return;
        if (2*nums[start]>target) return ;
        int lo=start;
        int hi=nums.length-1;
        while (lo<hi) {
            int sum=nums[lo]+nums[hi];
            if (sum==target) {
                result.add(Arrays.asList(firstfound,secondfound,nums[lo],nums[hi]));
                do lo++;
                while (lo+1<hi && nums[lo]==nums[lo-1]);
                do hi--;
                while (hi-1>lo && nums[hi]==nums[hi+1]);
            }
            if (sum<target) lo++;
            if (sum>target) hi--;
        }        
    }
}
