class Solution {
    public int search(int[] nums, int target) {
        int low=0, high= nums.length-1;
        // we want to include all possible cases including low <= high because we dont want the loop to miss the case when low == high.
        while(low <= high){
            int mid = (low +high) /2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[low] <= nums[mid]){
                /* if we give  if(nums[low] < target && target < nums[mid] ) then if target == nums[low] or nums[mid], then it would miss it in the left array and 
                  search in the right array which would be wrong
                */
                if(nums[low] <= target && target<=nums[mid] ){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }

            }
            else{
                if(nums[mid]<=target && target <= nums[high]){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }

            
        }
        return -1;
    }
}
