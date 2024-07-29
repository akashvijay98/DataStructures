class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> tempList = new ArrayList<>();
        
        tempList.add(0);
        dfs(graph,tempList,0);
        return result;
        
    }

    public void dfs(int[][] graph, List<Integer> tempList, int node){
        if(node == graph.length-1){
            result.add(new ArrayList<Integer>(tempList));
        }

        for(int curNode : graph[node]){
            tempList.add(curNode);
            dfs(graph,tempList,curNode);
            tempList.remove(tempList.size()-1);
        }
    }
}
