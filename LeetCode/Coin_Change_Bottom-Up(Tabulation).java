class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0; // it takes 0 no of coins to make 0

        for(int i=1;i<=amount;i++){
            for(int c : coins){
                // note: if dp[i-c]==MAX, then 1+dp[i-c] will become 1+Integer.MAX_VALUE will cause overflow.
                // 1+2,147,483,647 = -2,147,483,648
                
                if(i-c>=0 && dp[i-c]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);
                }
            }
        }

        return dp[amount]==Integer.MAX_VALUE? -1 : dp[amount] ;

    }
}
