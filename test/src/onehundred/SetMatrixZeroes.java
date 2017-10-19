package onehundred;

public class SetMatrixZeroes {
    // intuitive: use 1 horizontal 1 vertival array to mark if this col/row is to be set to 0
    // use m+n extra space for mxn matrix
    
    // constant space solution: use first row and col to store mark
    // the a[0][0] at crossing can be either row/col mark, use 1 more variable to store the other
    
    public void setZeroes(int[][] a) {
        int y=a.length;
        int x=a[0].length;
        if (y==0 && x==0) return;
        int row0=1;
        for (int i=0;i<x;i++) {
            if (a[0][i]==0) {
               row0=0;
               break;
            }
        }
        for (int i=1;i<y;i++) {             // skip row 0
            for (int j=0;j<x;j++) {
                if (a[i][j]==0) {
                    a[i][0]=0;
                    a[0][j]=0;
                }
            }
        }
        
        for (int i=y-1;i>0;i--) {
            for (int j=x-1;j>-1;j--) {
                if (a[i][0]==0 || a[0][j]==0) a[i][j]=0;
            }
        }
        if(row0==0) {
            for (int i=0;i<x;i++) {
                a[0][i]=0;
            }
        } 
    }
}
