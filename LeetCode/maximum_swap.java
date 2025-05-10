class Solution {
    public int maximumSwap(int num) {
        
    
        char[] nums = Integer.toString(num).toCharArray();
        int n=nums.length;
        
        int[] maxRightIndex = new int[n];

        maxRightIndex[n-1]=n-1;
        
        // first we compare the number at index i with number at maxRightIndex[i+1]
        
        // maxRightIndex will store the index of maximum element from index i to till n-1

        for(int i=n-2;i>=0;i--){
            if(nums[i]>nums[maxRightIndex[i+1]]){
                maxRightIndex[i]=i;
            }
            else maxRightIndex[i] =maxRightIndex[i+1]; 
        }

         // we compare the number at index i and maxRightIndex[i], we swap only when number at index i is less than maxRigthIndex[i] 
        // e.g. for number 9736 , maxRightIndex = [0,1,3,3]. so first two numbers will be skipped.
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
