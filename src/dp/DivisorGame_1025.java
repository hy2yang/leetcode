package dp;
/*
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
    Choosing any x with 0 < x < N and N % x == 0.
    Replacing the number N on the chalkboard with N - x.

Also, if a player cannot make a move, they lose the game.
Return True if and only if Alice wins the game, assuming both players play optimally.

Example 1:
Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.

Example 2:
Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.

Note:
    1 <= N <= 1000

 */
public class DivisorGame_1025 {

    public boolean divisorGame(int N) {
        if (N<4) return N%2==0;
        boolean[] win = new boolean[N+1];
        for (int i=1;i<=N;++i){
            for (int j=1;j<i;++j){
                if (i%j==0 && !win[i-j]){
                    win[i] =true;   // can win if there exist any i-j where component can't win
                    break;
                }
            }
        }
        return win[N];
    }
}
