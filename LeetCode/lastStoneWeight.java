class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);

        for(int stone : stones){
            heap.offer(stone);
        }

        while(heap.size()>=2){
            int a = heap.poll();
            int b = heap.poll();
            
            heap.offer(a-b);
        }
        return heap.poll();
    }
}
