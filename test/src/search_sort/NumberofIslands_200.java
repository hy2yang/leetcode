package search_sort;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
*/

// it is actually DFS searching for node

public class NumberofIslands_200 {
    
    public static int numIslands(char[][] grid) {
        if (grid.length<1 || grid[0].length<1) return 0;
        int x=grid.length;
        int y=grid[0].length;
        int res=0;
        for (int i=0;i<x;++i) {
            for (int j=0;j<y;++j) {                
                if (grid[i][j]=='1') {
                    expand(grid, i, j );
                    ++res;                    
                }                
            }
        }        
       return res;
    }
    
    
    private static void expand(char[][] grid, int i, int j) {        
        int x=grid.length;
        int y=grid[0].length;
        if (i < 0 || j < 0 || i > x-1 || j > y-1 || grid[i][j]!='1' ) return;
        grid[i][j] = '2';
        expand(grid, i-1, j );
        expand(grid, i+1, j );
        expand(grid, i, j-1 );
        expand(grid, i, j+1 );
        
    }
    
    public static void main(String[] args) {
        char[][] x={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(x));
    }

}
