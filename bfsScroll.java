// 994. Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>  q = new LinkedList<>();

        int freshCount = 0;
        
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        int time =0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean rottenNew = false;
            
            for(int i=0;i<size;i++){
                int[] cell = q.poll();
                int r = cell[0], c = cell[1];

                for(int[] d:directions){
                    int newRow = r+d[0], newCol = c+d[1];
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                        q.add(new int[]{newRow,newCol});
                        grid[newRow][newCol]=2;
                        rottenNew = true;
                        freshCount--;
                    }
                }
                
            }
            if(rottenNew){
                time++;
            }
           
        }
        return freshCount==0? time:-1;
    }
}
