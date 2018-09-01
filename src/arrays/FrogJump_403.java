package arrays;

import java.util.HashSet;
import java.util.Set;

/*
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order,
determine if the frog is able to cross the river by landing on the last stone.
Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units.
Note that the frog can only jump in the forward direction.

Note:
The number of stones is ≥ 2 and is < 1,100.
Each stone's position will be a non-negative integer < 231.
The first stone's position is always 0.

Example 1:

[0,1,3,5,6,8,12,17]

There are a total of 8 stones.
The first stone at the 0th unit, second stone at the 1st unit,
third stone at the 3rd unit, and so on...
The last stone at the 17th unit.

Return true. The frog can jump to the last stone by jumping
1 unit to the 2nd stone, then 2 units to the 3rd stone, then
2 units to the 4th stone, then 3 units to the 6th stone,
4 units to the 7th stone, and 5 units to the 8th stone.

Example 2:

[0,1,2,3,4,8,9,11]

Return false. There is no way to jump to the last stone as
the gap between the 5th and 6th stone is too large.
*/
public class FrogJump_403 {

    public boolean canCross(int[] stones) {
        if (stones == null || stones.length<1) return false;

        Set<Integer> stonePos = new HashSet<>();
        for (int i=1;i<stones.length;++i){
            if (stones[i]-stones[i-1]>i) return false;   // at stones[i-1], longest possible last jump is i-1
            stonePos.add(stones[i]);                     // so longest possible next jump is i
        }

        return reachable(1, stones[stones.length-1], 1, stonePos);
    }

    private boolean reachable(int cur, int target, int k, Set<Integer> stonePos) {
        if (!stonePos.contains(cur) || k<1) return false;
        if ( cur==target ) return true;
        return reachable(cur+k+1, target, k+1, stonePos)    // mind the order of these 3!
                ||reachable(cur+k, target, k, stonePos)        // check longer jumps first otherwise TLE
                ||reachable(cur+k-1, target, k-1, stonePos); // makes sense since longer jumps reachs faster
    }



}
