class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr){
            map.put(i, map.getOrDefault(i,0)+1);
        }   

        PriorityQueue<Integer> frequencies = new PriorityQueue<>(map.values());

        int elementsRemoved=0;

        while(!frequencies.isEmpty()){
            elementsRemoved += frequencies.peek();

            if(elementsRemoved > k){
                return frequencies.size();
            }
            frequencies.poll();

        }

        return 0;

    }
}
