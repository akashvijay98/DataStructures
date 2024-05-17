class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int nodesVisited = 0;

        for(int i = 0; i<numCourses;i++){
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            nodesVisited++;

            for(int neighbour : adj.get(node)){
                inDegree[neighbour]--;

                if(inDegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
        if(nodesVisited == numCourses){
            return true;

        }
        else{
            return false;
        }
    }
}
