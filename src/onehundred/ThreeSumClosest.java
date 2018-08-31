package onehundred;
import java.util.*;

public class ThreeSumClosest {
    
    public static void main(String args[]) {
        int[] a = {-3,0,1,2};
        System.out.println(threeSumClosest(a,1));
    }
    
    static public int threeSumClosest(int[] nums, int target) {
        if (nums.length<3) return Integer.valueOf(null);
        if (nums.length==3) return nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        int sum=nums[0]+nums[1]+nums[nums.length-1];
        for (int i=0;i<nums.length-2;i++) {
            if(i>0 && nums[i-1]==nums[i]) continue;
            int lo=i+1;
            int hi=nums.length-1;            
            while (lo<hi) {
                if (nums[i]+nums[lo]+nums[hi]==target) return target;
                if (Math.abs(target-nums[i]-nums[lo]-nums[hi])<Math.abs(target-sum)) {
                    sum=nums[i]+nums[lo]+nums[hi];                    
                    }
                if (nums[i]+nums[lo]+nums[hi]<target) lo++;
                else hi--;
            }
        }        
        return sum;
    }

}
