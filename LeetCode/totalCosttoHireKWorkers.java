class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>();

        for(int i=0;i<candidates;i++){
            minHeap1.add(costs[i]);

        }
        for(int j=Math.max(candidates, costs.length - candidates); j < costs.length;j++){
            minHeap2.add(costs[j]);
        }

        long ans = 0;
        int nextHead = candidates;
        int nextTail = costs.length-candidates-1;

        for(int i=0;i<k;i++){
            if(minHeap2.isEmpty()||!minHeap1.isEmpty()&& minHeap1.peek()<=minHeap2.peek()){
                ans+=minHeap1.poll();
            
            if(nextHead <= nextTail){
                    minHeap1.add(costs[nextHead]);
                    nextHead++;
                }

            }
            else{
                ans+=minHeap2.poll();

                if(nextHead <= nextTail){
                    minHeap2.add(costs[nextTail]);
                    nextTail--;
                }

            }
        }
        return ans;
    }
}
