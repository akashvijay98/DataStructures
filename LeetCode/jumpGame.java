class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // FAILURE CASE:
            // If the current index 'i' is beyond our current reach, 
            // it means we are stuck and cannot step here.
            if (i > maxReach) {
                return false;
            }
            
            // UPDATE REACH:
            // Can we jump further from here than we could before?
            // Current position (i) + Jump power (nums[i])
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // OPTIMIZATION:
            // If we can already reach the last index, stop early.
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}
