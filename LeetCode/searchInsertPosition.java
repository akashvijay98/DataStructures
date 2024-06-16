class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1 ;

        /* 
         (while (left <= right)), the loop ensures that all possible positions are checked,
          and left ends up at the correct insert position.

          if we use while(left<right) instead of while(left<=right), 
          the loop exits one iteration earlier when left equals right. 
          This means the final comparison to determine the insert position is not directly handled within the loop.
        
        */
        while(left <= right){
            int mid = (left+right)/2;

            if(nums[mid]>target){
                right = mid-1;

            }
            else if(nums[mid]<target){
                left= mid+1;
            }
            else{
                return mid;
            }
        }
        return left;
    }
}
