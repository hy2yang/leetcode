package onehundred;

public class WordSearch {
    
    public boolean exist(char[][] b, String word) {
        if (word=="") return true;
        int y=b.length;
        int x=b[0].length;
        if ((x*y)<word.length()) return false;
        char[] target=word.toCharArray();
        for (int i=0;i<y;i++) {
            for (int j=0;j<x;j++) {
                if (b[i][j]==target[0]) {
                    char temp=b[i][j];
                    b[i][j]=' ';
                    if (helper(b,target,i,j,1)) return true;
                    b[i][j]=temp;
                }
            }
        }
        return false;
    }
    
    static boolean helper(char[][] b, char[] target, int y, int x, int pos) {
        if (pos==target.length) return true;
        
        if( y>0 && b[y-1][x]==target[pos] ) {
            char temp=b[y-1][x];
            b[y-1][x]=' ';
            if (helper(b,target,y-1,x,pos+1)) return true;
            b[y-1][x]=temp;
        }
        
        if( y<b.length-1 && b[y+1][x]==target[pos] ) {
            char temp=b[y+1][x];
            b[y+1][x]=' ';
            if (helper(b,target,y+1,x,pos+1)) return true;
            b[y+1][x]=temp;
        }
        
        if( x>0 && b[y][x-1]==target[pos] ) {
            char temp=b[y][x-1];
            b[y][x-1]=' ';
            if (helper(b,target,y,x-1,pos+1)) return true;
            b[y][x-1]=temp;
        }
        
        if( x<b[0].length-1 && b[y][x+1]==target[pos] ) {
            char temp=b[y][x+1];
            b[y][x+1]=' ';
            if (helper(b,target,y,x+1,pos+1)) return true;
            b[y][x+1]=temp;
        }
        return false;
    }

}
