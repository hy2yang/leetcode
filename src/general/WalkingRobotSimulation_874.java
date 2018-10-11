package general;

import java.util.HashSet;
import java.util.Set;

/*
A robot on an infinite grid starts at point (0, 0) and faces north.
The robot can receive one of three possible types of commands:
-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units

Some of the grid squares are obstacles.
The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
If the robot would try to move onto them, the robot stays on the previous grid square instead
(but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.

Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)

Note:
0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
 */
public class WalkingRobotSimulation_874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dir = {0,1};
        int[] pos = {0,0};
        int res = 0;
        int dsquare = 0;

        Set<String> obs = new HashSet<>();   // don't use Arrays.HashCode()! hash collision -> different arrays could have same hashcode
        for (int[] o : obstacles) {
            obs.add(o[0] + "," + o[1]);
        }

        for (Integer i :commands){
            if (i<0){
                rotate(dir, i);
            } else {
                while (i>0){
                    if(obs.contains((pos[0]+dir[0]) + "," + (pos[1]+dir[1]))) break;

                    pos[0] += dir[0];
                    pos[1] += dir[1];
                    --i;
                }
                res = Math.max(res, pos[0]*pos[0] + pos[1]*pos[1]);
            }
        }

        return res;
    }

    private void rotate(int[] dir, int i){
        // turn left: x=-y, y=x
        // turn right: x=y, y=-x
        int temp = dir[0];
        dir[0] = dir[1];
        dir[1] = temp;
        if (i==-2) {
            dir[0] = -dir[0];
        }
        if (i==-1) {
            dir[1] =-dir[1];
        }
    }

}
