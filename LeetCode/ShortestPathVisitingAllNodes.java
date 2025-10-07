class Solution {
    public int shortestPathLength(int[][] graph) {
            Queue<int[]> q = new LinkedList<>();

            int n = graph.length;

            int[][] dist  = new int[1<<n][n];

            int targetmask = (1 << n) - 1;


            for(int[] row: dist){
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            for(int i=0;i<n;i++){
                int initialMask = 1 << i;
                dist[initialMask][i]=0;
                q.add(new int[]{initialMask, i});
            }

            while(!q.isEmpty()){
                int [] node = q.poll();

                int mask = node[0];
                int u = node[1];

                int d = dist[mask][u];

                if(mask == targetmask){
                    return d;
                }

                for(int v : graph[u]){
                    int newMask= mask | (1 << v);
                    if(dist[newMask][v]> d+1){
                        dist[newMask][v] = d+1;

                        q.add(new int[]{newMask,v});
                    }
                }
            }

            return -1;

    }
}
