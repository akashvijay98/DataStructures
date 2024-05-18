class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inEdges = new int[numCourses];

        int[] order = new int[numCourses];
        int index=0;

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            adj.get(prereq[1]).add(prereq[0]);
            inEdges[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(inEdges[i]==0){
                q.offer(i);
            }
        }

        int visited=0;
        while(!q.isEmpty()){
            int node = q.poll();
            order[index++]=node;
            visited++;

            for(int neighbour : adj.get(node)){
                inEdges[neighbour]--;
                if(inEdges[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
    System.out.println("visited====="+visited);
    if(visited==numCourses){
        return order;
    }
    return new int[0];
        
    }
}
