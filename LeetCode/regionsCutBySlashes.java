

import static java.lang.Math.log;

class Solution {

      private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 },
    };

    public int regionsBySlashes(String[] grid) {
        int size = grid.length;

        int[][] expandedGrid = new int[size*3][size*3];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int baseRow = i*3;
                int baseCol = j*3;

                if(grid[i].charAt(j)=='\\'){
                    expandedGrid[baseRow][baseCol]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol+2]=1;
                }
                else if(grid[i].charAt(j)=='/'){
                    expandedGrid[baseRow][baseCol+2]=1;
                    expandedGrid[baseRow+1][baseCol+1]=1;
                    expandedGrid[baseRow+2][baseCol]=1;
                }
            }
        }

        int regionCount=0;

        for(int i=0;i<size*3;i++){
            for(int j=0;j<size*3;j++){
                if(expandedGrid[i][j]==0){
                    floodFill(expandedGrid,i,j);
                    regionCount++;
                }
            }
        }
        return regionCount;
    }

    void floodFill(int[][] expandedGrid,int row,int col){
        Queue<int[]> queue = new LinkedList<>();
        int n = expandedGrid.length;
        expandedGrid[row][col] = 1;
        queue.add(new int[] {row,col});

        while(!queue.isEmpty()){
            int[] currentCell = queue.poll();

            for(int [] direction : DIRECTIONS){
                int newRow = direction[0] + currentCell[0];
                int newCol = direction[1] + currentCell[1];

                if(newRow>=0 && newCol>=0 && newRow<n && newCol<n && expandedGrid[newRow][newCol]==0){
                    expandedGrid[newRow][newCol]=1;
                    queue.add(new int[] {newRow, newCol});
                }

            }
            
        }

    }

}
