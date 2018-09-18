package general;
/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example:

[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Answer: 16
 */
public class IslandPerimeter_463 {

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int land=0, joint=0;
        for (int x=0;x<grid.length;++x){
            for (int y=0;y<grid[0].length;++y){
                if (grid[x][y]==1){
                    ++land;
                    if (x>0 && grid[x-1][y]==1) ++joint;
                    if (y>0 && grid[x][y-1]==1) ++joint;
                }
            }
        }
        return 4*land-2*joint;   // 1 land = 4 edges, 1 joint =-2 edges
    }


    public int islandPerimeter_count(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res=0;
        for (int x=0;x<grid.length;++x){
            for (int y=0;y<grid[0].length;++y){
                if (x==0) {
                    if (grid[x][y]==1) ++res;
                }
                else if (grid[x][y]!=grid[x-1][y]) ++res;
                if (x==grid.length-1 && grid[x][y]==1) ++res;

                if (y==0){
                    if (grid[x][y]==1) ++res;
                }
                else if (grid[x][y]!=grid[x][y-1]) ++res;
                if (y==grid[x].length-1 && grid[x][y]==1) ++res;
            }
        }
        return res;
    }
}
