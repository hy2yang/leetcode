package arrays;
/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
*/

public class JumpGame_55 {
    
    public boolean canJump(int[] a) {
        if(a==null || a.length==0) return false; 
        int range=0;
        for (int i=0;i<a.length && i<=range ;++i) {
            if (i+a[i]>range) range=i+a[i];
        }
        return range>=a.length-1;
    }

}
