import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length; // Correct 'n' based on passingFees array length

        // minCost[city][time] stores the minimum cost to reach 'city' in 'time' minutes
        int[][] minCost = new int[n][maxTime + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int travelTime = edge[2];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, travelTime});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, travelTime});
        }

        // PriorityQueue: stores (cost, time, city)
        // Sort by cost, then by time
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.cost != b.cost) {
                return a.cost - b.cost;
            }
            return a.time - b.time;
        });

       
        minCost[0][0] = passingFees[0];
        pq.add(new Node(0, 0, passingFees[0]));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.city;
            int currentTime = current.time;
            int currentCost = current.cost;

           
            if (currentCost > minCost[u][currentTime]) {
                continue;
            }

            // If we reached the destination city, we can potentially stop here
            // (though we need to find the overall minimum later)
            // No, in this case, we continue until PQ is empty to find the absolute min

            if (graph.containsKey(u)) { // Check if the city has outgoing edges
                for (int[] neighbor : graph.get(u)) {
                    int v = neighbor[0];
                    int travelTime = neighbor[1];

                    int newTime = currentTime + travelTime;
                    int newCost = currentCost + passingFees[v];

                    if (newTime <= maxTime) {
                        // If we found a path to 'v' with 'newTime' that has lower cost
                        if (newCost < minCost[v][newTime]) {
                            minCost[v][newTime] = newCost;
                            pq.add(new Node(v, newTime, newCost));
                        }
                    }
                }
            }
        }

        int overallMinCost = Integer.MAX_VALUE;
        for (int time = 0; time <= maxTime; time++) {
            overallMinCost = Math.min(overallMinCost, minCost[n - 1][time]);
        }

        return overallMinCost == Integer.MAX_VALUE ? -1 : overallMinCost;
    }

    // Node class for the PriorityQueue
    class Node {
        int city;
        int time;
        int cost;

        public Node(int city, int time, int cost) {
            this.city = city;
            this.time = time;
            this.cost = cost;
        }
    }
}
