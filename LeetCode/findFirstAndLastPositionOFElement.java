class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo=0,hi=nums.length-1;

        int[] result = new int[2];

        int index = -1;

        while(lo<=hi){
            int mid= (lo+hi)/2;

            if(nums[mid]==target){
                index = mid;
                hi=mid-1;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }

          result[0] = index;
        
         lo=0;
         hi=nums.length-1;
         index = -1;

        while(lo<=hi){
            int mid = (lo+hi)/2;

            if(nums[mid]==target){
                index = mid;
                lo = mid+1;
            }
            else if(nums[mid]<target){
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }

     
            result[1]=index;
        

        return result;
    }
}
