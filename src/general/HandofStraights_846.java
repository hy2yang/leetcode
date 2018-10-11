package general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

/*
Alice has a hand of cards, given as an array of integers.
Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
Return true if and only if she can.

Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].

Example 2:
Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.

Note:
1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
 */
public class HandofStraights_846 {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W!=0) return false;
        Map<Integer, Integer> freq = new TreeMap<>();  // get natual order of cards

        for (int c:hand){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        for (int cur: freq.keySet()){
            int count = freq.get(cur);
            if (count>0){
                for (int i=0;i<W;++i){
                    int num = freq.getOrDefault(cur+i, 0);
                    if (num<count) return false;
                    else freq.put(cur+i, num-count);
                }
            }

        }
        return true;
    }

    public boolean isNStraightHand_faster(int[] hand, int W) {
        if (hand.length%W!=0) return false;

        Map<Integer, Integer> freq = new TreeMap<>();  // get natual order of cards
        Deque<Integer> q = new ArrayDeque<>(); // records number of straights for each start

        for (int c:hand){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        int open = 0;  // number of sequences to be finished
        int pre = -2; // previous number aka end of sequence
        for (int cur: freq.keySet()){
            int count = freq.get(cur);

            if (open>0 && (cur!=pre+1 || count<open)) return false;  // can't append all open sequences

            q.offer(count-open); // count left after appending open sequences
            open = count;
            if (q.size()==W){
                open -= q.poll();  // end {num of start at cur-W} open sequences
            }

            pre = cur;
        }

        return open==0;
    }
}
