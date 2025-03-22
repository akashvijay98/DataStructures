class Solution {

    /*
        we take the max element as lo, and the total sum as hi

        we take the mid value of these two, and check if we can split the 
        array into k subarrays.
        if yes then we make a not of the maxSum nad try to reduce the right side.

        **note the lesser the maxSumAllowed, more number of splits in the array 


    */

    public int splitArray(int[] nums, int k) {

        int result = 0;

        int sum=0;
        int maxElement = Integer.MIN_VALUE;

        for(int num:nums){  
            sum+=num;
            maxElement = Math.max(maxElement, num);
        }

        int lo = maxElement;
        int hi = sum;

        while(lo<=hi){
            int mid =  lo + (hi - lo) / 2;

            if(split(nums,mid)<=k){
                hi = mid-1;
                result = mid;
            }
            else{
                lo=mid+1;
            }
        }

        return result;

    }

    private int split(int[] nums, int m){
        int currentSum = 0 ;
        int count = 1;

        for(int num:nums){
            if(currentSum+num<=m){
                currentSum+=num;
            }
            else{
                currentSum = num;
                count++;
            }
        }

        return count;
    }
}
