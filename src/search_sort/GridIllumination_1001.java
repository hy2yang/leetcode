package search_sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
On a N x N grid of cells, each cell (x, y)
with 0 <= x < N and 0 <= y < N has a lamp.

Initially, some number of lamps are on.
lamps[i] tells us the location of the i-th lamp that is on.
Each lamp that is on illuminates every square on its x-axis, y-axis,
and both diagonals (similar to a Queen in chess).

For the i-th query queries[i] = (x, y), the answer to
the query is 1 if the cell (x, y) is illuminated, else 0.

After each query (x, y) [in the order given by queries],
we turn off any lamps that are at cell (x, y) or
are adjacent 8-directionally (ie., share a corner or edge with cell (x, y).)

Return an array of answers.
Each value answer[i] should be equal to the answer of the i-th query queries[i].

Example 1:
Input: N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
Explanation:
Before performing the first query we have both lamps [0,0] and [4,4] on.
The grid representing which cells are lit looks like this,
where [0,0] is the top left corner, and [4,4] is the bottom right corner:
1 1 1 1 1
1 1 0 0 1
1 0 1 0 1
1 0 0 1 1
1 1 1 1 1
Then the query at [1, 1] returns 1 because the cell is lit.
After this query, the lamp at [0, 0] turns off, and the grid now looks like this:
1 0 0 0 1
0 1 0 0 1
0 0 1 0 1
0 0 0 1 1
1 1 1 1 1
Before performing the second query we have only the lamp [4,4] on.
Now the query at [1,0] returns 0, because the cell is no longer lit.

Note:
1 <= N <= 10^9
0 <= lamps.length <= 20000
0 <= queries.length <= 20000
lamps[i].length == queries[i].length == 2
 */
public class GridIllumination_1001 {

    public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

        Map<Integer, Set<Integer>>[] line = new HashMap[4];
        // horizontal, vertical, y=x+c, y=-x+c

        for (int i=0;i<4;++i){
            line[i] = new HashMap<>();
        }

        for (int i=0;i<lamps.length;++i){
            light(line, lamps[i][0], lamps[i][1], true);
        }

        int[] res = new int[queries.length];

        for (int i=0;i<queries.length;++i){
            int x = queries[i][0];
            int y = queries[i][1];
            res[i] = isLit(line, x, y);
            lightoff(line, x, y, N);
        }

        return res;
    }

    private int isLit(Map<Integer, Set<Integer>>[] line, int x, int y){
        int[] keys = {y, x, y-x, y+x};
        for (int i=0;i<line.length;++i){
            Set<Integer> temp = line[i].get(keys[i]);
            if (temp!=null && temp.size()>0) return 1;
        }
        return 0;
    }


    private void light(Map<Integer, Set<Integer>>[] line, int x, int y, boolean on){
        int[] keys = {y, x, y-x, y+x};
        int[] vals = {x, y, x, y};
        if (on){
            for (int i=0;i<4;++i){
                if (line[i].get(keys[i])==null){
                    line[i].put(keys[i], new HashSet<>());
                }
                line[i].get(keys[i]).add(vals[i]);
            }
        }
        else {
            for (int i=0;i<4;++i){
                Set<Integer> temp = line[i].get(keys[i]);
                if (temp!=null){
                    temp.remove(vals[i]);
                }
            }
        }

    }

    private void lightoff(Map<Integer, Set<Integer>>[] line, int x, int y, int N){
        int[] dx = {1,1,0,-1,-1,-1,0,1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};

        int newx, newy;
        for (int i=0;i<dx.length;++i){
            newx = x+dx[i];
            newy = y+dy[i];
            if (newx>=0 && newx<N && newy>=0 && newy<N){
                light(line, newx, newy, false);
            }

        }
    }
}
