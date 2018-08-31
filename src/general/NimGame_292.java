package general;
/*
You are playing the following Nim Game with your friend:
    There is a heap of stones on the table, each time one of you take turns to remove 1 to 3 stones. 
    The one who removes the last stone will be the winner. You will take the first turn to remove the stones.

Both of you are very clever and have optimal strategies for the game. 
Write a function to determine whether you can win the game given the number of stones in the heap.

For example, if there are 4 stones in the heap, then you will never win the game: 
    no matter 1, 2, or 3 stones you remove, the last stone will always be removed by your friend.
*/
public class NimGame_292 {
    
    public boolean canWinNim(int n) {
        if (n<4) return true;
        boolean[] dp= {true,true,true,true};
        for (int i=0;i<n/4;++i) {
            dp[0]=!(dp[1]&&dp[2]&&dp[3]);
            dp[1]=!(dp[0]&&dp[2]&&dp[3]);
            dp[2]=!(dp[0]&&dp[1]&&dp[3]);
            dp[3]=!(dp[0]&&dp[1]&&dp[2]);
        }
        return dp[n%4];
    }
    
    
    
    /*
f(x) = (f(x-2)&&f(x-3)&&f(x-4)) || (f(x-3)&&f(x-4)&&f(x-5)) || (f(x-4)&&f(x-5)&&f(x-6))
if we examine the equation a little closer, we can find f(x - 4) is a critical point, if f(x-4) is false, then f(x) will be always false.

we can also find out the initial conditions, f(1), f(2), f(3) will be true (A always win), and f(4) will be false. so
based on previous equation and initial conditions f(5) = f(6) = f(7) = true, f(8) = false;
obviously, f(1), f(2), f(3) can make all f(4n + 1), f(4n + 2), f(4n + 3) to be true, only f(4n) will be false then.

    public boolean canWinNim(int n) {
        return n%4!=0;
    }
     */
}
