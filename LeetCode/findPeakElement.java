class Solution {
    public int findPeakElement(int[] nums) {

        if(nums.length==1){
            return 0;
        }

        if(nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }

        int left = 0, right= nums.length-1;


        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }
            else if(nums[mid]<nums[mid-1]){
                right = mid-1;
            }
            else{
            return mid;
            
            }            

        }
        return 0;

    }
}
