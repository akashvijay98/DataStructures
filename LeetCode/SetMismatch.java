class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int idx = Math.abs(nums[i])-1;

            if(nums[idx]>0){
                nums[idx] = -nums[idx];
            }
            else{
                //The duplicate is the value we are holding, not the value AT the index
                res[0]=Math.abs(nums[i]);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                res[1]=i+1;
            }
        }

        return res;
    }
}
