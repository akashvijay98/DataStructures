class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        
        // by default dp contains 1 at all indexes, so by default dp[i]=1(if we include only that number)
        Arrays.fill(dp, 1);

        int max = 0;

        

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){

                    //for example take array        [10,9,2,5,3,7,101,18]
                    //when i= 5, nums[i]=7 , dp[] = [ 1,1,1,2,2,_]
                    // we start inner for loop j = 0 to i  ... j=0,1 not valid(nums[j]>nums[i]), j=2,3 --> dp[i]=2 until now dp[i]=2
                    // for j=4, nums[j]=3 . dp[3] = 2, so max(2, 2+1) = 3. so dp[i] = 3
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        for(int len:dp){
            max = Math.max(max,len);
        }

        return max;
        
    }
}
