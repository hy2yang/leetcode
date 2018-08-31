package search_sort;
/*
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
*/
public class SudokuSolver_37 {
    
    public void solveSudoku(char[][] board) {
        helper(board,0);        
    }
    
    private boolean helper(char[][] board, int pos) {
        if (pos>=81) return true;                     //all filled
        if (board[pos/9][pos%9]=='.') {               // try to fill this
            for (char i='1';i<='9';++i) {
                if (isValid(board,pos/9,pos%9, i)) {  // a valid number to fill here
                    board[pos/9][pos%9]=i;              
                    if (helper(board,pos+1)) return true;
                    board[pos/9][pos%9]='.';          // will not lead to solution, erase this
                }
            }
            return false;                             // nothing can be filled here, return to last cell
        }
        return helper(board,pos+1);                   // if this cell is already filled, look into next
    }
    
    private boolean isValid(char[][] board, int x, int y, char c) {        
        for (int i=0;i<9;++i) {
            if( board[i][y]==c || board[x][i]==c || board[3*(x/3)+i/3][3*(y/3)+i%3]==c ) {
                return false;
            }
        }
        return true;        
    }

}
