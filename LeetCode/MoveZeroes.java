class Solution {
    public void moveZeroes(int[] nums) {
        int leftPointer= 0;
        for(int rightPointer =0; rightPointer< nums.length; rightPointer++){
            if(nums[rightPointer]!=0){

               // swap the non-zero element(right Pointer value) with the last zero element so far.
                swap(nums,leftPointer ,rightPointer); 

                //update the new non-zero element's index
                leftPointer++;
            }
        }
    }

    public void swap(int[] nums, int left,int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right] = temp;
    }
}
