package search_sort;
/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.
Every time you guess wrong, I'll tell you whether the number is higher or lower.
You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

-1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 
Example:
n = 10, I pick 6.
Return 6.
*/
public class GuessNumberHigherorLower_374 {
    
    public int guessNumber(int n) {
        int lo=1, hi=n, mid, temp;
        while (lo<=hi){
            mid= lo+(hi-lo)/2;
            temp=guess(mid);
            if (temp==0) return mid;
            else if (temp<0) hi=mid-1;
            else lo=mid+1;
        }
        return -1;
    }
    
    private int guess(int n) {
        return 0;
    }

}
