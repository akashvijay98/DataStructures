class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int[] i : flights){
            if(!adj.containsKey(i[0])){
                adj.put(i[0],new ArrayList<>());
            }
            adj.get(i[0]).add(new int[] {i[1],i[2]});
        }

        int[] price = new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);

        int stops = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});

        while(!q.isEmpty() && stops<=k){
            int size = q.size();

            while(size>0){
                int[] temp= q.poll();

                int node = temp[0];
                int totalPrice = temp[1];
                System.out.println("total price====="+totalPrice);

                if(adj.containsKey(node)){
                   for(int[] d : adj.get(node)){
                        int neighbor = d[0];
                        System.out.println("neighbor=="+neighbor);
                        if((totalPrice+d[1]) < price[neighbor]){
                            price[neighbor] = totalPrice+d[1]; 
                            q.offer(new int[]{neighbor,price[neighbor]});
                        }
                    } 
                }
                size--;
            }
            stops++;          
        }      
        return price[dst]==Integer.MAX_VALUE ? -1:price[dst];
        
        
    }

  
}
