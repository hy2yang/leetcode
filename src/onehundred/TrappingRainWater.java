package onehundred;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] a= {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(mytrap(a));

    }
    
    public static int trap(int[] height) {
        int i=0;
        int j=height.length-1;
        int water=0;
        int min=0;
        while (i<j) {
            if (height[i]<height[j]) {
                min=height[i];
                while (i<j && height[i]<=min) {
                    water+=min-height[i++];
                }
            }
            else {
                min=height[j];
                while (i<j && height[j]<=min) {
                    water+=min-height[j--];
                }
            }        
        }
        return water;        
    }
    
    public static int mytrap(int[] height) {
        int water=0;
        int[] lmax=new int[height.length];
        int[] rmax=new int[height.length];
        int max=0;
        for (int i=0;i<height.length;i++) {
            lmax[i]=Math.max(height[i], max);
            max=lmax[i];
        }
        max=0;
        for (int i=height.length-1;i>-1;i--) {            
            rmax[i]=Math.max(height[i], max);
            max=rmax[i];
        }
        for (int i=0;i<height.length;i++) {
            int level=Math.min(lmax[i], rmax[i]);
            if (level>height[i]) water+=level-height[i];
        }
        return water;
    }

}
