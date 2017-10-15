
public class SpiralMatrixII {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(generateMatrix(3));
    }
    
    public static int[][] generateMatrix(int n) {
        int[][] m=new int[n][n];
        if (n == 0) return m;
        int x=0;
        int y=0;
        int i=1;
        while (true) {            
            for (int j=x;j<n-x-1;j++) {
                m[y][j]=i;
                i++;
            }
            if (i>=n*n) {
                if (n%2==0) break;
                else {
                    m[n/2][n/2]=i;
                    break;
                }
            }
            for (int j=y;j<n-y-1;j++) {
                m[j][n-x-1]=i;
                i++;
            }
            for (int j=n-x-1;j>x;j--) {
                m[n-y-1][j]=i;
                i++;
            }
            for (int j=n-y-1;j>y;j--) {
                m[j][x]=i;
                i++;
            }
            x++;
            y++;             
        }
        return m; 
    }

}
