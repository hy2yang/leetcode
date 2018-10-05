package search_sort;

import java.util.*;

/*
We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever.
For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels
in the sequence 1->5->7->1->5->7->1->... forever.

We start at bus stop S (initially not on a bus), and we want to go to bus stop T.
Travelling by buses only, what is the least number of buses we must take to reach our destination?
Return -1 if it is not possible.

Example:

Input:
routes = [[1, 2, 7], [3, 6, 7]]
S = 1
T = 6
Output: 2
Explanation:
The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.

Note:
1 <= routes.length <= 500.
1 <= routes[i].length <= 500.
0 <= routes[i][j] < 10 ^ 6.
 */
public class BusRoutes_815 {

    // least number - indicates bfs
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;

        Set<Integer> taken = new HashSet<>();
        Deque<Integer> toCheck = new ArrayDeque<>();
        Map<Integer, Set<Integer>> canTake = new HashMap<>();

        for (int i=0;i<routes.length;++i){
            for (int j=0;j<routes[i].length;++j){
                int cur = routes[i][j];
                if (!canTake.containsKey(cur)){
                    canTake.put(cur, new HashSet<Integer>());
                }
                canTake.get(cur).add(i);
            }
        }

        toCheck.offer(S);

        int step = 0;
        while (!toCheck.isEmpty()){
            for (int size = toCheck.size();size>0;--size){
                int pos = toCheck.poll();
                if (pos == T) return step;
                Set<Integer> buses = canTake.get(pos);
                for (Integer busNum:buses){
                    if (!taken.add(busNum)) continue;
                    for (Integer next:routes[busNum]){
                        toCheck.offer(next);
                    }
                }
            }
            ++step;
        }
        return -1;
    }
}
