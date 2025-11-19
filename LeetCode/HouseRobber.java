class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int[] dp = new int[n];

        if(nums.length==1){
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            
            /* here you choose the maximum loot if you include current house nums[i] and the maxloot unttill the dp[i-2] house  'or' the max loot until previous house dp[i-1] and skip current house */

            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
        }

        return dp[n-1];
    }
}
