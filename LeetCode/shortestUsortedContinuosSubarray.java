class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int nums_min = Integer.MAX_VALUE;
        int nums_max = Integer.MIN_VALUE;
        int lo = 0; int hi = nums.length-1;

        while(lo<nums.length-1 && nums[lo]<=nums[lo+1]){
            lo++;

        }
        if(lo==nums.length-1){
            return 0;
        }

        while(hi>0 && nums[hi]>=nums[hi-1]){
            hi--;
        }
        
        for(int i = lo;i<=hi;i++){
        nums_min = Math.min(nums[i],nums_min);
        nums_max = Math.max(nums[i],nums_max);

        }
      
        while(lo>0 && nums[lo-1]>nums_min){
            lo--;
        }
        while(hi < nums.length-1 && nums_max>nums[hi+1]){
            hi++;
        }

        return hi-lo+1;
    }
}
