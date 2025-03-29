class Solution {
    public int maximumSwap(int num) {
        
    
        char[] nums = Integer.toString(num).toCharArray();
        int n=nums.length;
        
        int[] maxRightIndex = new int[n];

        maxRightIndex[n-1]=n-1;

        // maxRightIndex will store the index of maximum element from index i to till n-1

        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[maxRightIndex[i+1]]){
                maxRightIndex[i]=i;
            }
            else maxRightIndex[i] =maxRightIndex[i+1]; 
        }

        for(int i=0;i<n;i++){
            if(nums[i]<nums[maxRightIndex[i]]){
                char temp = nums[i];
                nums[i]=nums[maxRightIndex[i]];
                nums[maxRightIndex[i]] = temp;

                return Integer.parseInt(new String(nums));
            }
        }

        return num;
    }
}
