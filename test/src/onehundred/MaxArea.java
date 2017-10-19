package onehundred;

public class MaxArea {
    static public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int maxl=l;
        int maxr=r;
        while (l<r && l<height.length-1 && r>0){
            if (height[l]>height[r]) r--;
            else l++;
            if (findArea(height, maxl, maxr)<findArea(height, l,r)) {
                maxl=l;
                maxr=r;
            }
        }
        return findArea(height, maxl, maxr);
    }
    
    static int findArea(int[] height, int i, int j){
        return Math.min(height[i],height[j])*(j-i);
    }
}
