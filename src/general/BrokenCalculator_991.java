package general;
/*
On a broken calculator that has a number showing on its display,
we can perform two operations:
Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.
Initially, the calculator is displaying the number X.

Return the minimum number of operations needed to display the number Y.

Example 1:
Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

Example 2:
Input: X = 5, Y = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.

Example 3:
Input: X = 3, Y = 10
Output: 3
Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.

Example 4:
Input: X = 1024, Y = 1
Output: 1023
Explanation: Use decrement operations 1023 times.

Note:
1 <= X <= 10^9
1 <= Y <= 10^9
 */
public class BrokenCalculator_991 {
    public int brokenCalc(int X, int Y) {
        if (X>=Y) return X-Y;
        return (Y&1)==0? 1+brokenCalc(X, Y/2):1+brokenCalc(X, Y+1);

    }

    public int brokenCalc_iterative(int X, int Y) {
        int move = 0;
        while(Y>X){
            ++move;
            Y = (Y&1)==0? Y>>1:Y+1;
        }
        return X-Y+move;
    }

}

/*
So we check only the last bit of Y, since doubling and -1 can only alter (directly) one bit.

if last bit of Y is 0, the last operation must be doubling, we trace back to Y/2
if last bit of Y is 1, the last operation must be decrement, we trace back to Y+1

Trying to prove that the if last bit of Y is 0, the last operation must be doubling:

hypothesis: there can be one or more decrement from Y+1 to Y in the shortest path, where last bit of Y is 0

since last bit of Y+1 is 1, it must be decrement from Y+2(doubling can never make an 1 on last bit)
two options at Y+2.
decrement from Y+3, it's the same as the starting point Y+1 and Y;
doubling from (Y+2)/2, three moves used from (Y+2)/2 to Y: double to Y+2, decrement to Y+1, decrement to Y, while there is a shorter path: decrement to Y/2, double to Y
there we get a contradiction to the hypothesis
so the hypothesis is false
hence, there can be none decrement move(s) from Y+1 to Y in the shortest path if last bit of Y is 0
*/
