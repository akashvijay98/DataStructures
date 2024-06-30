class Solution {
    public boolean search(int[] nums, int target) {
    //we can observe that all the elements of the second array S will be smaller or equal to
    // the first element start of F.

    int left= 0, right = nums.length-1;

    while(left <= right){
        int mid = (left+right)/2;
        if(nums[mid]==target){
            return true;
        }
        if(nums[left]< nums[mid]){  // first portion
            if(nums[left] <= target && target < nums[mid]){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        } 

        else if(nums[left] > nums[mid]){ // right portion
            if(nums[mid]<target && target <= nums[right]){
                left = mid+1;
                

            }
            else{
               right = mid-1;
            }
        }
        else{
            left+=1;
        }

    }
    return false;
    }
    
}
