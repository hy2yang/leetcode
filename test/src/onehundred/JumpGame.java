package onehundred;

public class JumpGame {
    
    public static boolean canJump(int[] nums) {
        int max=0;
        for (int i=0;i<nums.length;i++) {
            if (max<i) return false;
            if (max>=nums.length-1) return true;
            max=Math.max(max, (i+nums[i]));            
        }
        return true;
    }
    
    public static void main(String[] args) {
        int[] a= {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(canJump(a));
    }

}
