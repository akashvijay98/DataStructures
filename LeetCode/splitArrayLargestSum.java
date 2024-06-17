class Solution {
    public int splitArray(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;
        
        
        for(int num:nums){
            maxVal = Math.max(maxVal,num);
            sum+=num;
        }
        int res = sum;

        int left = maxVal;
        int right = sum;

        while(left<=right){
            int mid = (left+right)/2;

            boolean isPartition = canPartition(nums,k,mid);

            if(isPartition){
                res= mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }



        }

        return res;
    }

    public boolean canPartition(int[] nums,int k, int maxSize){
        int subArrayCount =1;
        int totalSum = 0;

        for(int num:nums){
            if(totalSum+num<=maxSize){
                totalSum+=num;
            }
            else{
                subArrayCount++;
                totalSum=num;
            }

        }
        if(subArrayCount<=k){
            return true;
        }
        else{
            return false;
        }
    }
}
