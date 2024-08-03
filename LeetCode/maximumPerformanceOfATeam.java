class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];


        }
        Arrays.sort(arr,(a,b)->b[1]-a[1]);
        
        long sum=0;
        long ans = 0;

        Queue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            int spd = arr[i][0];
            int minEff = arr[i][1];

            sum+=spd;
            pq.add(spd);

            if(pq.size()>k){
                sum-=pq.remove();
            }
            ans = Math.max(ans,sum*minEff);
       
        }
        return (int)(ans %1000000007);
    



    }
}
