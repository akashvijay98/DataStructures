class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        int minutesCount = 0;

        int[][] directions = new int[][] {{0,-1},{0,1},{1,0},{-1,0}};

        // first lets count all the fresh oranges
        // we also add the rotten oranges to the queue
        for(int r = 0; r< grid.length; r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    freshOranges++;
                }
                if(grid[r][c]==2){
                    q.offer(new int[]{r,c});
                }
            }
        }

        //the loop will run until there are no more fresh oranges to get rotten
        while(!q.isEmpty() && freshOranges>0){

            int size = q.size();
            for(int i=0;i<size;i++){
                int[] rottenOrange = q.poll();

                int row = rottenOrange[0];
                int col = rottenOrange[1];

                for(int[] d: directions){
                    int r= row+d[0];
                    int c= col+d[1];

                    if(r>=0 && r<grid.length && c>=0 && c< grid[0].length ){

                        if(grid[r][c]==1){
                            grid[r][c]=2;
                            freshOranges--;
                            q.offer(new int[] {r,c});
                        }
                  
                    }
                }
            }
            // when the for loop finishes executing, it is counted as a minute since all the initial items 
            // before the start of for loop in the que are removed and processed
            minutesCount++;

        }
        if(freshOranges>0){
            return -1;

        }
        else{
            return minutesCount;
        }
    }
}
