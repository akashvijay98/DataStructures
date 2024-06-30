class Solution {
    public int[] searchRange(int[] nums, int target) {

       

        if(nums.length==0){
            return new int[] {-1,-1};
        }

        int[] result = new int[2];

        int leftIndex = findBound(nums,target,true);
        result[0]=leftIndex;

        int rightIndex = findBound(nums,target,false);
        result[1]= rightIndex;

        

        return result ;
    }

    public int findBound(int[]  nums, int target, boolean isFirst){
        int left =0, right = nums.length-1;
        while(left<=right){
            int mid = (left+right)/2;

           
            if(nums[mid]==target){
                if(isFirst){
                    if(left==mid || nums[mid-1] != target){
                        return mid;
                    }
                    else{
                        right = mid-1;
                    }  
                }
                else{
                    if(right==mid || nums[mid+1] != target){
                        return mid;
                    }
                    else{
                        left = mid+1;
                    }
                }                     

            }

            else if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
}
