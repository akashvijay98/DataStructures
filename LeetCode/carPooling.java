class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int curPass =0;
        Arrays.sort(trips,(a,b)->a[1]-b[1]);

        for(int[] trip:trips){
            int passengers = trip[0];
            int start =trip[1];
            int end = trip[2];
            while(!pq.isEmpty() && pq.peek()[1]<=start){
                curPass -= pq.peek()[0];
                pq.poll();
            }

            curPass+=passengers;

            if(curPass>capacity){
                return false;
            }
            pq.offer(new int[]{passengers,end});
        }
    return true;
       
    }
}
