class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0]=0;

        // to reach step i, there are two possible ways: 1. reach i from i-1 or 2. reach i  from i-2
        for(int i=0;i<n;i++){
            // to reach step 1 the min cost is cost[0], and to reach step 2, min cost = cost[1]
            if(i<2) dp[i]=cost[i];
            else dp[i]= cost[i] + Math.min(dp[i-1], dp[i-2]);

        }
        // dp array is 0 indexed, so to get to top floor n the min cost would be min(dp[n-1], dp[n-2])
        return Math.min(dp[n-1], dp[n-2]);

    }
}
