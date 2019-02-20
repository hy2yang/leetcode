package search_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/*
In a given grid, each cell can have one of three values:
the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally)
to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.
If this is impossible, return -1 instead.

Example 1:
Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
because rotting only happens 4-directionally.

Example 3:
Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.

Note:
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
 */
public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        Set<Integer> fresh = new HashSet<>();
        Deque<Integer> bane = new ArrayDeque<>();

        for (int i=0;i<grid.length;++i){
            for (int j=0;j<grid[0].length;++j){
                if (grid[i][j]==1){
                    fresh.add(i*grid[0].length+j);
                } else if (grid[i][j]==2){
                    bane.offer(i*grid[0].length+j);
                }
            }
        }

        int step = 0;

        while (fresh.size()>0 && bane.size()>0){
            int size = fresh.size();

            for (int i=bane.size(); i>0;--i){
                rot(fresh, bane, grid, bane.poll());
            }

            if (fresh.size()==size) return -1;
            ++step;
        }
        return fresh.isEmpty()? step:-1;
    }

    private void rot(Set<Integer> fresh, Deque<Integer> bane, int[][] grid, int pos){
        int x = pos/grid[0].length;
        int y = pos%grid[0].length;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        for (int p=0;p<4;++p){
            int i = x+dx[p];
            int j = y+dy[p];
            if (i>=0 && i<=grid.length-1 && j>=0 && j<=grid[0].length-1 && grid[i][j]==1){
                fresh.remove(i*grid[0].length+j);
                bane.offer(i*grid[0].length+j);
                grid[i][j]=2;
            }
        }

    }
}
