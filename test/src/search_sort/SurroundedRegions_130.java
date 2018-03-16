package search_sort;
/*
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/
public class SurroundedRegions_130 {
    
    public void solve(char[][] board) {
        if (board==null || board.length<1) return;        
        for (int i=0;i<board.length; ++i){
            for (int j=0;j<board[0].length;++j){
                if ( i==0 || i==board.length-1 || j==0 || j==board[0].length-1){
                    if (board[i][j]=='O') mark_dfs(board, i ,j);
                }
            }
        }
        
        for (int i=0;i<board.length; ++i){
            for (int j=0;j<board[0].length;++j){
                if (board[i][j]=='L') board[i][j]='O';
                else board[i][j]='X';
            }
        }
        return;
    }
    
    private void mark_dfs(char[][] board, int x, int y){
        if (x<0 || x>=board.length || y<0 || y>=board[0].length) return;
        if (board[x][y]!='O') return;
        board[x][y]='L';
        if (x+1<board.length) mark_dfs(board, x+1, y);
        if (x-1>=0) mark_dfs(board, x-1, y);
        if (y+1<board[0].length) mark_dfs(board, x, y+1);
        if (y-1>=0) mark_dfs(board, x, y-1);
        
    }

}
