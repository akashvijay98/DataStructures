class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;;
        int cols = grid[0].length;
       
        boolean vis[][]=new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                vis[i][j]=false;
            }
        }

        Queue<pair> q=new LinkedList<>();
        int ans=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    ans++;
                    q.add(new pair(i,j));
                    bfs(vis,grid,q);
                }
            }
        }


        return ans;

    }

    public void bfs(boolean vis[][], char[][] grid, Queue<pair> q){
        int n=grid.length;
        int m=grid[0].length;
       
        int cr[]={-1,0,1,0};

        int cc[]={0,1,0,-1};


        while(!q.isEmpty()){

            int row=q.peek().r;
            int col=q.peek().c;
            q.poll();

            for(int i=0;i<4;i++){
                int lr=row+cr[i];

                int lc=col+cc[i];
                if(lr>=0 && lr<n && lc>=0 && lc<m && vis[lr][lc]==false && grid[lr][lc]=='1'){
                    vis[lr][lc]=true;
                    q.add(new pair(lr,lc));
                }
            }
        }
    }
}
class pair{
    int r;
    int c;
    pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
