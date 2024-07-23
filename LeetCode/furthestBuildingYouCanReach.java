class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Create a priority queue with a comparator that makes it behave as a min-heap.
        PriorityQueue<Integer> allocatedLadders = new PriorityQueue<>();

        for(int i=0;i<heights.length-1;i++){
            int difference = heights[i+1]-heights[i];

            if(difference<0){
                continue;
            }

            allocatedLadders.add(difference);

            if(allocatedLadders.size()>ladders){
                bricks -= allocatedLadders.remove();
            }
            if(bricks<0){
                return i;
            }


        }
        return heights.length -1;

    }
}
