class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];

        PriorityQueue<int[]>maxHeap = new PriorityQueue<> ((a,b)->(b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));

        for(int[] p :points){
            maxHeap.offer(p);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }

        }
        int i=0;
        while(!maxHeap.isEmpty()){
            ans[i++] = maxHeap.poll();

        }
        return ans;
    }
}
