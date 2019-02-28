package search_sort;
/*
On an 8 x 8 chessboard, there is one white rook.
There also may be empty squares, white bishops, and black pawns.
These are given as characters 'R', '.', 'B', and 'p' respectively.

Uppercase characters represent white pieces,
and lowercase characters represent black pieces.

The rook moves as in the rules of Chess:
it chooses one of four cardinal directions (north, east, west, and south),
then moves in that direction until it chooses to stop,
reaches the edge of the board,
or captures an opposite colored pawn by moving to the same square it occupies.
Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.

Example 1:
Input: [
[".",".",".",".",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".","R",".",".",".","p"],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
In this example the rook is able to capture all the pawns.

Example 2:
Input: [
[".",".",".",".",".",".",".","."],
[".","p","p","p","p","p",".","."],
[".","p","p","B","p","p",".","."],
[".","p","B","R","B","p",".","."],
[".","p","p","B","p","p",".","."],
[".","p","p","p","p","p",".","."],
[".",".",".",".",".",".",".","."],
[".",".",".",".",".",".",".","."]]
Output: 0
Explanation:
Bishops are blocking the rook to capture any pawn.

Example 3:
Input: [
[".",".",".",".",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".","p",".",".",".","."],
["p","p",".","R",".","p","B","."],
[".",".",".",".",".",".",".","."],
[".",".",".","B",".",".",".","."],
[".",".",".","p",".",".",".","."],
[".",".",".",".",".",".",".","."]]
Output: 3
Explanation:
The rook can capture the pawns at positions b5, d6 and f5.

Note:
board.length == board[i].length == 8
board[i][j] is either 'R', '.', 'B', or 'p'
There is exactly one cell with board[i][j] == 'R'
 */

public class AvailableCapturesforRook_999 {

    public int numRookCaptures(char[][] board) {
        int x=-1;
        int y=-1;
        for (int i=0;i<board.length;++i){
            for (int j=0;j<board[0].length;++j){
                if (board[i][j] == 'R'){
                    x=i;
                    y=j;
                    break;
                }
            }
        }

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int[] res = new int[1];

        for (int i=0;i<4;++i){
            go(x, y, board, dx[i], dy[i], res);
        }
        return res[0];
    }


    private void go(int x, int y, char[][] board, int dx, int dy, int[] res){
        while (x>=0 && x<board[0].length && y>=0 && y<board[0].length){
            if (board[x][y]=='B') break;
            if (board[x][y]=='p'){
                ++res[0];
                break;
            }
            x+=dx;
            y+=dy;
        }
    }

}
