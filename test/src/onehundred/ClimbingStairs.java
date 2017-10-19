package onehundred;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        int before1=2;
        int before2=1;
        int sum=0;
        for (int i=3;i<=n;i++) {            
            sum+=before1+before2;            
            before2=before1;
            before1=sum;
        }
        return sum;
        
/*      if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 2;
        return climbStairs(n-1)+climbStairs(n-2);
        //simple but slow
         
*/
    }

}
