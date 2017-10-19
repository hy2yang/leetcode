package onehundred;

public class MaximumSubarray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++) {
            sum+=nums[i];
            sum=Math.max(sum,nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }

}
