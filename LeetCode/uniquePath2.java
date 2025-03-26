class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];

        for(int[] edges : memo){
            Arrays.fill(edges,-1);
        }
        return dfs(0,0,m,n,obstacleGrid,memo);
    }

    private int dfs(int r, int c, int m, int n, int[][] grid, int[][] memo){
        
        // if cell goes out of bounds, then we return 0
        if(r>=m || c>=n){
            return 0;
        }

        // we check if the grid is an obstacle first so that even if the last cell is an obstacle we return 0.

        if(grid[r][c]==1){
            return 0;
        }

        // the final cell condition should occur only after the obstacle condition otherwise the cell will return 1 even if the final cell is obstacle
        if(r==(m-1)&& c==(n-1)){
            return 1;
        }

     

        if(memo[r][c]!=-1){
            return memo[r][c];
        }

        memo[r][c] = dfs(r+1,c,m,n,grid,memo) + dfs(r,c+1,m,n,grid,memo);
        return memo[r][c];
    }
}
