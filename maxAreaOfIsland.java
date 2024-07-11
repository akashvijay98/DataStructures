class Solution {
   
    int rowDirections[]={-1,0,1,0};
    int colDirections[]={0,1,0,-1};
    int max = 0;
    int sum=0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;;
        int cols = grid[0].length;
       
       

        for(int r=0;r<rows;r++ ){
            for(int c =0;c<cols;c++){
                if(grid[r][c]==1){
                   max = Math.max(max,dfs(grid,r,c));
                }
            }
        }
       
        return max;

        
    }
    public int dfs(int[][] grid, int row, int col){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==0) {
            return 0;
        }
        grid[row][col]=0;
        return 1+dfs(grid, row+1,col)+dfs(grid,row-1,col)+dfs(grid,row,col+1)+dfs(grid,row,col-1);
    }
}
class Pair{
    int r;
    int c;

    public Pair(int r, int c){
        this.r= r;
        this.c= c;
    }
}
