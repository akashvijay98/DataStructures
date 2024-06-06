class Solution {
    int maxTime = Integer.MIN_VALUE;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);

        //first create a 2D arrayList
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }

        // here go to the index of the manager, and then add the subordinate node(create an edge from manager to the subordinate)
        // because in dfs, we first traverse from root(manager) to the leaf(subordinates)
        for(int i=0;i<n;i++){
            if(manager[i]!=-1){
                adj.get(manager[i]).add(i);
            }
        }
        dfs(adj,informTime,headID,0);

        return maxTime;

    }

    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] informTime, int curr,int time){
        
        //we compare max time at the begining because imagine an edge 2->1, which has informtIME of 3;
        //at node 2 the maxTime is 0 becuase 2 is the head and there is no one above 2.
        // at node 1,since 2 is above 2, we check and add informTIme[1] (time+informTime[curr]) and then calculate the max sum.
        maxTime = Math.max(maxTime,time);

        for(int adjacentNode : adj.get(curr)){
            dfs(adj,informTime,adjacentNode,time+informTime[curr]);
        }
    }
}
