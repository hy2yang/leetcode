
public class UniquePathsII {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int l=obstacleGrid.length;
        int s=obstacleGrid[0].length;
        if (l==0 || s==0) return 0;
        int[] swiper =new int[s];
        
        for (int i=0;i<s;i++) {
            if (obstacleGrid[0][i]==1) break;
            else swiper[i]=1;
        }
        
        for (int i=1;i<l;i++) {
            if (obstacleGrid[i][0]==1) swiper[0]=0;
            for (int j=1;j<s;j++) {
                if (obstacleGrid[i][j]==1) swiper[j]=0;
                else swiper[j]+=swiper[j-1];
            }
        }
        return swiper[s-1];
    }

}
