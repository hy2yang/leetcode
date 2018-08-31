package bitManipulation;
/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: 
    You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, 
    which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/
public class GameofLife_289 {
    
    public void gameOfLife(int[][] board) {
        if (board.length<0 || board[0].length<0) return;
        
        int x=board.length,y=board[0].length;
        int temp;
        for (int i=0;i<x;++i) {
            for (int j=0;j<y;++j) {
                temp=liveNeighbors(board,x,y,i,j);
                if (board[i][j]==1) {
                    if (temp>1 && temp<4) board[i][j]=3;  //bit 11
                }
                else if (temp==3) board[i][j]=2; //bit 10
            }
        }
        for (int i=0;i<x;++i) {
            for (int j=0;j<y;++j) {
                board[i][j]>>=1;
            }
        }
    }
    
    private int liveNeighbors(int[][] board, int x ,int y, int posx, int posy) {
        int res=0;
        for (int i=Math.max(posx-1, 0);i<=Math.min(posx+1, x-1);++i) {
            for (int j=Math.max(posy-1, 0);j<=Math.min(posy+1, y-1);++j) {
                if (i==posx && j==posy) continue;
                else res+=(board[i][j]&1);
            }
        }
        return res;
    }
    
   /* 
    To solve it in place, we use 2 bits to store 2 states:
        [2nd bit, 1st bit] = [next state, current state]
        - 00  dead (next) <- dead (current)
        - 01  dead (next) <- live (current)  
        - 10  live (next) <- dead (current)  
        - 11  live (next) <- live (current)
*/
}
