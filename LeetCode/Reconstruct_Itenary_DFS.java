// source: https://neetcode.io/problems/reconstruct-flight-path
public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();

        //build adjacency map to map source: [destination]
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new ArrayList<>());
        }
        
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        for (List<String> ticket : tickets) {
            adj.get(ticket.get(0)).add(ticket.get(1));
        }
        
        List<String> res = new ArrayList<>();
        res.add("JFK");
        
        // if all the airports are visited, return the result
        //  tickets.size() + 1 because we are including JFK(initial source)
        if (dfs("JFK", res, adj, tickets.size() + 1)) {
            return res;
        }
        return new ArrayList<>();
    }
    
    private boolean dfs(String src, List<String> res, 
                        Map<String, List<String>> adj, int targetLen) {
        if (res.size() == targetLen) {
            return true;
        }
        
        if (!adj.containsKey(src)) {
            return false;
        }
        
        List<String> temp = new ArrayList<>(adj.get(src));
        for (int i = 0; i < temp.size(); i++) {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            // if all the nodes are visited, then return true and break for loop
            if (dfs(v, res, adj, targetLen)) return true;

            // add v node to the i'th index inside the list adj.get(src)
            // we do this because the list is lexographically sorted
            adj.get(src).add(i, v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
