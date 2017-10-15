
public class RotateImage {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public void rotate(int[][] matrix) {
        int lo=matrix.length-1;
        int hi=0;
        while (hi<lo) {
            int[] temp= matrix[lo];
            matrix[lo]=matrix[hi];
            matrix[hi]=temp;
            hi++;
            lo--;
        }
        
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<i;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }            
        }
    }

}
