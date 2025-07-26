class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[n];

        int[] color = new int[n + 1];

        Arrays.fill(color,-1);

        for(int[] edge : dislikes){
            int a = edge[0], b= edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }

        for(int i=1;i<=n;i++){
            if(color[i]==-1){
                if(!bfs(i,map,color)) return false;
            }
        }
        return true;

    }

    private boolean bfs(int src, HashMap<Integer, List<Integer>> map, int[] color){
        Queue<Integer> q = new LinkedList<>();
        color[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            if(!map.containsKey(node)){
                continue;
            }
            for(int neighbor : map.get(node)){
                if(color[neighbor]==color[node]){
                    return false;
                }
                if(color[neighbor]==-1){
                    // if color[node]=1, color[nei] = 1-1 = 0
                    // if color[node]=0, color[nei] = 1-0 = 1
                    color[neighbor]= 1-color[node];

                    q.add(neighbor);
                }
            }
        }
        return true;
    }
}
