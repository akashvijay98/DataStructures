/* 
Approach:
---------
we perform simple binary search and return the position if target is found 
else we keep moving hi and lo pointers and reduce the search space until lo > hi and return lo.

* why do we return lo?
    lets take an example nums = [1,3,5,6], target = 8
    here the position is at the end of the array, greater than hi. 
    hence we set the while() loop condition in such a way that it exits the loop only when lo>hi 

* why is while(lo<=hi)?
    (while (left <= right)), the loop ensures that all possible positions are checked,
    and left ends up at the correct insert position.
    
    if we use while(left<right) instead of while(left<=right), 
    the loop exits one iteration earlier when left equals right. 
    This means the final comparison to determine the insert position is not directly handled within the loop.

*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo=0, hi = nums.length-1; 
        while(lo<=hi){
            int mid = (lo+hi)/2;

            if(nums[mid]==target){
                return mid;
            }

            else if(nums[mid]>target){
                hi = mid-1;
            }
            else if(nums[mid]<target){
                lo = mid+1;
            }
        }
        return lo;
    }
}
