package search_sort;
/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) 
connected 4-directionally (horizontal or vertical.) 
You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
        
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
        
Note: The length of each dimension in the given grid does not exceed 50.
*/
public class MaxAreaofIsland_695 {
    
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length<1 || grid[0].length<1 ) return 0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        int res=0;
        for (int i=0;i<grid.length;++i) {
            for (int j=0;j<grid[0].length;++j) {
                if (grid[i][j]==1 && !visited[i][j]) {
                    int island=dfs(grid,i,j,visited);
                    if (island>res) res=island;
                }
            }
        }
        return res;
    }
    
    private int dfs(int[][] grid, int x, int y, boolean[][] visited) {        
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        visited[x][y]=true;
        int res=1;
        for (int[] d : directions) {
            int newx = x+d[0];
            int newy = y+d[1];
            if ( newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length && grid[newx][newy]==1 && !visited[newx][newy]) {
                res+=dfs(grid, newx, newy, visited);
            }            
        }
        return res;
    }

}
