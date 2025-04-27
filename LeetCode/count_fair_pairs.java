class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans =0;

        for(int i=0;i<nums.length;i++){

            // lo will return the first index from where nums[i] + nums[index] is >= low
            //  nums[i] + nums[j] >= lower i.e nums[j] >= lower - nums[i]

            // hi will return the last index from where nums[i]+nums[j] is <= upper
            // nums[i]+nums[j] <= upper i.e nums[j] <= upper - nums[j]

            int lo = binarySearch(nums,i+1,nums.length-1,lower-nums[i]);
            int hi = binarySearch(nums,i+1,nums.length-1,upper-nums[i]+1);

            ans += 1 * (hi - lo);
        }

        return ans;
    }
    private int binarySearch(int[] nums, int lo, int hi, int target ){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]>=target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return lo;
    }
}
