class Solution {
    public int waysToSplitArray(int[] nums) {
        long prefixSum =0;
        long sum=0;
        int  count=0;

        for(int i=0;i<nums.length;i++){
            prefixSum+=nums[i];
        }

        for(int i=0;i<nums.length-1;i++){
            sum+=nums[i];
            if(sum>= prefixSum-sum){
                count++;

            }

        }
        return count;

    }
}
