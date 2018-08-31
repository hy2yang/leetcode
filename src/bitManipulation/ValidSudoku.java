package bitManipulation;

import java.util.HashSet;

public class ValidSudoku {
    
    public boolean isValidSudoku_bit(char[][] board) {
        int row,col,block;
        for (int i=0;i<9;i++) {
            row=0;
            col=0;
            block=0;
            int temp;
            for (int j=0;j<9;j++) {
                if( board[i][j]!='.' ){
                    temp=board[i][j]-'1';
                    if((row&(1<<temp))>0) return false;
                    row|=(1<<temp);
                }                
                if( board[j][i]!='.' ){
                    temp=board[j][i]-'1';
                    if( (col&(1<<temp))>0) return false;
                    col|=(1<<temp);
                }                
                if( board[3*(i/3)+j/3][3*(i%3)+j%3]!='.'){
                    temp=board[3*(i/3)+j/3][3*(i%3)+j%3]-'1';
                    if ((block&(1<<temp))>0) return false;
                    block|=(1<<temp);
                }                 
            }
        }
        return true;
    }
    
    public boolean isValidSudoku_set(char[][] board) {
        HashSet<Character> row=new HashSet<>();
        HashSet<Character> col=new HashSet<>();
        HashSet<Character> block=new HashSet<>();
        for (int i=0;i<9;i++) {
            row.clear();
            col.clear();
            block.clear();
            for (int j=0;j<9;j++) {
                if( board[i][j]!='.' && !row.add(board[i][j])) return false;
                if( board[j][i]!='.' && !col.add(board[j][i])) return false;
                if( board[3*(i/3)+j/3][3*(i%3)+j%3]!='.' && !block.add(board[3*(i/3)+j/3][3*(i%3)+j%3])) return false;
            }
        }
        return true;       
    }
}
