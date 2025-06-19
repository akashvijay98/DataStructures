class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();

        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        q.add(new int[]{entrance[0],entrance[1],0});

        boolean[][] visited = new boolean[maze.length][maze[0].length];
         visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            int[] cell = q.poll();

            int r= cell[0];
            int c= cell[1];
            int steps = cell[2];

               
           

            if(maze[r][c] == '.'){
                if((r!=entrance[0] || c!=entrance[1]) &&(r==0 ||  r==maze.length-1 ||c==0|| c==maze[0].length-1)){
                    return steps;
                }
               
            }

            for(int [] d : dir){
                int newR = r+d[0];
                int newC = c+d[1];

                if(newR<0 || newR>=maze.length || newC<0 || newC>=maze[0].length || visited[newR][newC] || maze[newR][newC]=='+'){
                continue;
                }   
                
 
                q.add(new int[]{newR,newC,steps+1});

                
                visited[newR][newC] = true;
                
                
            }




        }
        return -1;

    }
}
