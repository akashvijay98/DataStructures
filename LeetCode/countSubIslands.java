class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n=grid1.length;
        int m = grid1[0].length;

        boolean[][] visited = new boolean[n][m];
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid1[i][j] ==1 && grid2[i][j]==1 && dfs(grid1, grid2,visited,i,j)){
                    ans++;
                }

            }
        }
        return ans;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col){

        //we first check if the correspoding cell in grid2 is land and grid1 is also land.
        //if grid2 cell is water then we return true, because we are only interested in continous landmass
        //if grid1 cell is water and grid2 cell is land, then that means grid2 is not a subisland of grid1 
        // so we'll immediately return false

        if(row<0 || col<0 || row>=grid1.length || col>=grid1[0].length || visited[row][col] || grid2[row][col]!=1){
            return true;
        }
        if(grid1[row][col]!=1){
            return false;
        }
        visited[row][col]=true;

        boolean ans = true;

        ans = ans & dfs(grid1,grid2,visited,row+1,col);
        ans = ans & dfs(grid1,grid2,visited,row-1,col);
        ans = ans & dfs(grid1,grid2,visited,row,col+1);
        ans = ans & dfs(grid1,grid2,visited,row,col-1);

        return ans;
    }
}
