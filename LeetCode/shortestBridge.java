// link:  https://leetcode.com/problems/shortest-bridge/submissions/1649927522/

// Approach: DFS and BFS 

// similar to: https://leetcode.com/problems/making-a-large-island/description/

class Solution {

    Queue<int[]> q = new LinkedList<>();

    int[][] dir = new int[][]{ {0,1},{0,-1},{1,0},{-1,0} };

    public int shortestBridge(int[][] grid) {
        int r=-1,c=-1;
        outer:
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    r=i;
                    c=j;
                    break outer;
                }
            }

        }
        dfs(r,c,grid);
        
        int res = 0;
        while(!q.isEmpty()){
            int size=  q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int x = node[0];
                int y= node[1];
                
                
                    for(int[] d:dir){
                        int newX = x + d[0];
                        int newY = y + d[1];

                        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length)
                            continue;

                        if (grid[newX][newY] == 1)
                            return res;

                        if (grid[newX][newY] == 0) {
                            grid[newX][newY] = 2;
                            q.add(new int[] {newX, newY});
                        }
                    
                    }
                
            }
            res++;
            

        }

        return -1;
    }

    private void dfs(int x, int y,int[][] grid){
        
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=1){
            return;
        }

        grid[x][y]=2;
        q.add(new int[]{x,y});
        for(int i=0;i<dir.length;i++){
            int newX = x+dir[i][0];
            int newY = y+dir[i][1];
        
            dfs(newX,newY,grid);
        }


    }


}
