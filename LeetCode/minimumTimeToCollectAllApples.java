class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        int result = 0;

        for(int[] edge : edges){
            int a=edge[0];
            int b = edge[1];
            map.computeIfAbsent(a, value -> new ArrayList<Integer>()).add(b);
            map.computeIfAbsent(b, value -> new ArrayList<Integer>()).add(a);
        }
        result = dfs(0,-1,map,hasApple);

        return result;
    }

    public int dfs(int node, int parent, HashMap<Integer,ArrayList<Integer>> map, List<Boolean> hasApple){
        int total=0;
        
        if(!map.containsKey(node)){
            return 0 ;
        }


        for(int child : map.get(node)){

            if(child == parent){
                continue;
            }
            int count = dfs(child,node,map,hasApple);

            if(count>0 || hasApple.get(child)){
                total+=count+2;
            }

            
        }

        return total;

    }

}
