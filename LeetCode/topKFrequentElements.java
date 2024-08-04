class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] ans = new int[k];

        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            pq.offer(new int[]{freq,num});

            if(pq.size()>k){
                pq.poll();
            }

        }
        int pos =0;
        while(!pq.isEmpty()){
            ans[pos]=pq.peek()[1];
            pq.poll();
            pos++;
        }
        return ans;
    }
}
