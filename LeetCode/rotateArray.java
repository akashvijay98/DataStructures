class Solution {
    public void rotate(int[] nums, int k) {

        int l=0, r=nums.length-1;

        // if k is equals to nums.length, then there is no point of rotating, it wil be the same as original array
        // and k could also be greater than nums.length, thats why we do k=k%nums.length;
        k=k%nums.length;

        while(l<r){
            swap(l,r,nums);
            l++;
            r--;
        }

        int i=0,j=k-1;
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }

        i=k;
        j=nums.length-1;

        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
