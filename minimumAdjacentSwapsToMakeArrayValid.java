class Solution {
    public int minimumSwaps(int[] nums) {
        int minSwaps = 0;
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        int maxInd = -1;
        int minInd = -1;

        if(n==1){
            return 0;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=maxVal){
                maxInd = i;
                maxVal = nums[i];
            }

            if(nums[i]<minVal){
                minVal = nums[i];
                minInd = i;
            }
        }

        if(maxInd > minInd){
            minSwaps =  minInd + (n-maxInd-1);
        }
        else{
            minSwaps = n-maxInd-1;
            minSwaps +=minInd-1;
        }

        return minSwaps;



    }
}
