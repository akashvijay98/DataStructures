class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int number =0;

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                number++;
                dfs(i,isConnected,visited);
            }
        }
        return number;

    }

    public void dfs(int node, int[][] isConnected, boolean[] visited){
        visited[node] = true;

        for(int i=0; i<isConnected.length;i++){
            if(isConnected[node][i]==1 && !visited[i]){
                dfs(i,isConnected,visited);
            }
        }
    }
}
