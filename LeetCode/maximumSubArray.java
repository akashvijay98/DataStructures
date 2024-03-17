/* 
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i=0; i<nums.length;i++){
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);

            // if the currentsum is negative, there is no point of adding more elements to it because always it will reduce the sum.
            if(currentSum<0){
                currentSum = 0;
            }
            
        }
        return maxSum;
    }
}
