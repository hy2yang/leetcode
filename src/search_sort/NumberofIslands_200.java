package search_sort;

/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
*/

// it is actually DFS searching for node

public class NumberofIslands_200 {
    
    public int numIslands_dfs(char[][] grid) {
        if (grid.length<1 || grid[0].length<1) return 0;
        int x=grid.length;
        int y=grid[0].length;
        int res=0;
        for (int i=0;i<x;++i) {
            for (int j=0;j<y;++j) {                
                if (grid[i][j]=='1') {
                    dfs(grid, i, j );
                    ++res;                    
                }                
            }
        }        
       return res;
    }
    
    
    private void dfs(char[][] grid, int i, int j) {        
        int x=grid.length;
        int y=grid[0].length;
        if (i < 0 || j < 0 || i > x-1 || j > y-1 || grid[i][j]!='1' ) return;
        grid[i][j] = '2';
        dfs(grid, i-1, j );
        dfs(grid, i+1, j );
        dfs(grid, i, j-1 );
        dfs(grid, i, j+1 );
        
    }
    
    
    public int numIslands_UF(char[][] grid) {
        if (grid.length<1 || grid[0].length<1) return 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        unionFind uf = new unionFind(grid);
        int x=grid.length, y=grid[0].length;
        
        for (int i=0;i<x;++i){
            for (int j=0;j<y;++j){
                if (grid[i][j]=='1'){
                    for (int[] d : directions){
                        int newx = i+d[0];
                        int newy = j+d[1];
                        if ( newx >=0 && newx<x && newy>=0 && newy<y && grid[newx][newy]=='1' ){
                            uf.union(i*y+j , newx*y+newy);
                        }
                    }
                }
            }
        }        
        return uf.count;
    }
    
    class unionFind{
        int count;
        int[] parent;
        
        public unionFind(char[][] board){
            count=0;
            int x = board.length;
            int y = board[0].length;
            parent = new int[x*y];
            for (int i=0;i<x;++i){
                for (int j=0;j<y;++j){
                    if (board[i][j] == '1'){
                        parent[i*y+j]=i*y+j;
                        ++count;
                    }
                }
            }
        }
        
        public int find(int node){
            while ( parent[node]!=node ){
                node=parent[node];
            }
            return node;
        }
        
        public void union (int n1, int n2){
            int root1=find(n1);
            int root2=find(n2);
            if ( root1!=root2 ){
                parent[root1]=root2;
                --count;
            }
        }
    } 
    
    

}
