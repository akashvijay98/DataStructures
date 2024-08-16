class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum=0;
        int leftSum=0;

        for(int num:nums){
            rightSum+=num;
        }

        for(int i=0;i<nums.length;i++){
            if(rightSum-leftSum-nums[i]==leftSum){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
