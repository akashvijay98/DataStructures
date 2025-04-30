class Solution {
    public int maxProduct(int[] nums) {
        // Initialize max, min, and result with the first element
        int max = nums[0];     // current max product ending at index i
        int min = nums[0];     // current min product ending at index i (for handling negatives)
        int result = nums[0];  // overall maximum product so far

        // Example input: nums = [2, 3, -2, 4]

        for(int i = 1; i < nums.length; i++) {
            int temp = max;

            // Step by step trace:
            // i = 1, nums[1] = 3
            // temp = 2
            // max = max(3, max(3*2, 3*2)) = max(3, 6) = 6
            // min = min(3, min(3*2, 3*2)) = min(3, 6) = 3
            // result = max(2, 6) = 6

            // i = 2, nums[2] = -2
            // temp = 6
            // max = max(-2, max(-2*6, -2*3)) = max(-2, -6) = -2
            // min = min(-2, min(-2*6, -2*3)) = min(-2, -12) = -12
            // result = max(6, -2) = 6

            // i = 3, nums[3] = 4
            // temp = -2
            // max = max(4, max(4*-2, 4*-12)) = max(4, -8) = 4
            // min = min(4, min(4*-2, 4*-12)) = min(4, -48) = -48
            // result = max(6, 4) = 6

            max = Math.max(nums[i], Math.max(nums[i] * max, nums[i] * min));
            min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min));

            result = Math.max(result, max);  // update global max if needed
        }

        return result;  // Final result for [2, 3, -2, 4] is 6
    }
}
