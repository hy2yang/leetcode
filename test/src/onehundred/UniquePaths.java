package onehundred;

public class UniquePaths {
    
    public static int uniquePaths(int m, int n) {
        if (m==0 || n==0) return 0;
        if (m==1 || n==1) return 1;
        int l=Math.max(m, n);
        int s=Math.min(m, n);
        int[] swiper =new int[s];
        for (int i=0;i<s;i++) {
            swiper[i]=1;
        }
        
        for (int i=1;i<l;i++) {
            for (int j=1;j<s;j++) {
                swiper[j]+=swiper[j-1];
            }
        }
        return swiper[s-1];
    }
    
    public static void main(String[] args) {
        
        System.out.print(uniquePaths(2,2));
    }

}
