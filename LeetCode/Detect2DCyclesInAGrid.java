class Solution {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(dfs(grid, visited,i,j,-1,-1)){
                        return true;
                    }
                }
                
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, int r, int c, int pr, int pc){
        visited[r][c]=true;
        for(int[] d : dir){
            int nr = r+d[0];
            int nc = c+d[1];

            if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && grid[r][c]==grid[nr][nc]){
                if(nr==pr && nc==pc){
                    continue;
                }
                if(visited[nr][nc]){
                    return true;
                }

                if(dfs(grid, visited, nr, nc, r, c)){
                    return true;
                }
            }
        }
        return false;
        
    }
}
