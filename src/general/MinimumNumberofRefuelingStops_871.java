package general;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
A car travels from a starting position to a destination which is target miles east of the starting position.
Along the way, there are gas stations.
Each station[i] represents a gas station that is station[i][0] miles east of the starting position,
 and has station[i][1] liters of gas.
The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.
It uses 1 liter of gas per 1 mile that it drives.
When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
What is the least number of refueling stops the car must make in order to reach its destination?
If it cannot reach the destination, return -1.

Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.
If the car reaches the destination with 0 fuel left, it is still considered to have arrived.

Example 1:
Input: target = 1, startFuel = 1, stations = []
Output: 0
Explanation: We can reach the target without refueling.

Example 2:
Input: target = 100, startFuel = 1, stations = [[10,100]]
Output: -1
Explanation: We can't reach the target (or even the first gas station).

Example 3:
Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
Output: 2
Explanation:
We start with 10 liters of fuel.
We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
We made 2 refueling stops along the way, so we return 2.

Note:
1 <= target, startFuel, stations[i][1] <= 10^9
0 <= stations.length <= 500
0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
public class MinimumNumberofRefuelingStops_871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int stops = 0;
        int max = startFuel;

        PriorityQueue<Integer> options = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int pos = 0;
        while(max<target) {
            while (pos<stations.length && max >= stations[pos][0]) {
                options.offer(stations[pos++][1]);
            }
            if (!options.isEmpty()){
                max += options.poll();
            } else {
                return -1;
            }
            ++stops;
        }
        return stops;
    }
}
