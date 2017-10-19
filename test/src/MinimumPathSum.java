
public class MinimumPathSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public int minPathSum(int[][] grid) {
        int y=grid.length;
        int x=grid[0].length;
        int[] swiper;
        boolean ver;  //swipe direction, vertical or horizontal
        int dis;   // swipe distance
        if (x<=y){
            dis=y;
            ver=true;
            swiper=new int[x];
            int temp=0;
            for (int i=0;i<x;i++){
                swiper[i]=temp+grid[0][i];
                temp=swiper[i];
            }
        }
        else{
            dis=x;
            ver=false;
            swiper=new int[y];
            int temp=0;
            for (int i=0;i<y;i++){
                swiper[i]=temp+grid[i][0];
                temp=swiper[i];
            }
        }
        int min;
        for (int i=1;i<dis;i++){
            swiper[0]+= ver? grid[i][0]:grid[0][i];
            for (int j=1;j<swiper.length;j++){                
                if(ver){
                    min=Math.min(swiper[j], swiper[j-1]);
                    swiper[j]=(grid[i][j]+min);
                }
                else{
                    min=Math.min(swiper[j], swiper[j-1]);
                    swiper[j]=(grid[j][i]+min);
                }
            }            
        }        
        return swiper[swiper.length-1];
        
        /*
        if (x==1){
            for (int i=0;i<y;i++){
                res+=grid[i][0];
            }
            return res;
        }
        if (y==1){
            for (int i=0;i<x;i++){
                res+=grid[0][i];
            }
            return res;
        }
        */
    }

}
