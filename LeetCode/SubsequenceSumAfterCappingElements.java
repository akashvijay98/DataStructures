class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n= nums.length;

        boolean[] ans = new boolean[n];
        boolean[] dp = new boolean[k+1];

        dp[0] = true;

        Arrays.sort(nums);

        int i=0;

        for(int x=1;x<=n;x++){

            for(; i<n && nums[i]<x;i++){
                for(int j=k; j>=nums[i];j--){
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }

            int nCapped = n-i;

            for(int j=0;j<=nCapped;j++){
                int times = j*x;

                if(times>k) break;

                if(dp[k-times]){
                    ans[x-1] = true;

                    break;
                }
            }

        }
        return ans;
    }
}
/*
Uncapped Numbers
These are the elements from the nums array that are less than the current capping value x. For the purpose of the sum, these numbers retain their original value.

Capped Numbers
These are the elements from the nums array that are greater than or equal to the current capping value x. For the purpose of the sum, these numbers are "capped" at x, meaning their value is treated as x instead of their original value.
*/


/* 
Example
Let's trace subsequenceSumAfterCapping with nums = {1, 2, 4} and k = 5.

Initialization:

nums is sorted: {1, 2, 4}.

ans = {false, false, false}.

dp = {true, false, false, false, false, false} (size k+1 = 6).

i = 0.

x = 1:

Uncapped: No elements are < 1, so i remains 0. dp is unchanged.

Capped: nums[0], nums[1], nums[2] are capped at 1. There are 3 capped elements.

Check for sum k=5:

j=0: times = 0*1=0. dp[5-0] is false.

j=1: times = 1*1=1. dp[5-1] is false.

j=2: times = 2*1=2. dp[5-2] is false.

j=3: times = 3*1=3. dp[5-3] is false.

ans[0] remains false.

x = 2:

Uncapped: nums[0] = 1 < 2. The loop runs for i=0.

dp is updated for nums[0] = 1. dp[1] = dp[1] || dp[0], so dp[1] becomes true. dp is now {true, true, false, false, false, false}.

i becomes 1.

Capped: nums[1]=2 and nums[2]=4 are capped at 2. There are 2 capped elements.

Check for sum k=5:

j=0: times = 0*2=0. dp[5-0] is false.

j=1: times = 1*2=2. dp[5-2] is false.

j=2: times = 2*2=4. dp[5-4] is true. We found a solution: 1 (uncapped) + 2 (capped) + 2 (capped) = 5.

ans[1] becomes true, and the inner loop breaks. ans = {false, true, false}.

x = 3:

Uncapped: nums[0]=1 < 3 and nums[1]=2 < 3. The loop runs for i=1.

dp is updated for nums[1]=2. dp[2] = dp[2] || dp[0], dp[3] = dp[3] || dp[1], etc. dp becomes {true, true, true, true, false, false}.

i becomes 2.

Capped: nums[2]=4 is capped at 3. There is 1 capped element.

Check for sum k=5:

j=0: times = 0*3=0. dp[5-0] is false.

j=1: times = 1*3=3. dp[5-3] is true. Solution: 2 (uncapped) + 3 (capped) = 5.

ans[2] becomes true, inner loop breaks. ans = {false, true, true}.

x = 4:

Uncapped: nums[0]=1, nums[1]=2, nums[2]=4. The loop runs for i=2.

dp is updated for nums[2]=4. dp becomes {true, true, true, true, true, true}.

i becomes 3.

Capped: No elements are capped. n-i=0.

Check for sum k=5:

j=0: times = 0*4=0. dp[5-0] is true. Solution: 1+4 or 2+... etc. ans[3] becomes true.

Final ans is {false, true, true}. The loop terminates since x will go up to n=3. Wait, the loop should go to n=3. Yes, but x=4 is not valid. The loop for x runs from 1 to n. Oh, the loop is x<=n, so x goes up to 3.

Let's re-examine. nums is length 3, so n=3. The for loop is for(int x=1; x<=n; x++).

My previous trace for x=4 is wrong.

The loop for x is x=1 to 3. So the ans array is length 3.

Let's re-trace the example with the correct loop bounds.

nums = {1, 2, 4}, k = 5, n=3.

x = 1: ans[0] is false.

x = 2: nums[0]=1 is uncapped. dp has dp[1]=true. nums[1]=2, nums[2]=4 are capped at 2. We can form 2*2 from capped, and dp[5-4]=dp[1] is true. So ans[1] is true.

x = 3: nums[0]=1, nums[1]=2 are uncapped. dp has dp[1]=true, dp[2]=true, dp[3]=true. nums[2]=4 is capped at 3. We can form 1*3=3 from capped, and dp[5-3]=dp[2] is true. So ans[2] is true.

The final answer is {false, true, true}.
*/
