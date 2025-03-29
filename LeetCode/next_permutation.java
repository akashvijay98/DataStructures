class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int i=0;
        for(i=n-2;i>=0;i--){
            // we find the first number which is in decreasing order from the right

            // but dont think the numbers after index i are always in sorted order 
            // for example :  nums = [1, 3, 5, 4, 2] here 3<5, so all numbers after 3 are not in sorted order

            if(nums[i]<nums[i+1]){
                break;
            }
        }

        if(i>=0){
            for(int j=n-1;j>i;j--){
                if(nums[j]>nums[i]){
                    swap(nums,i,j);
                    break;
                }
            }

        }

       

        int start = i+1;
        int end = n-1;

        // after swapping nums[i] with nums[j] we know that all the elements in the array exist in descending order.
        // so we just reverse the numbers after index i to get the next permutation 

        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }


    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
