class Solution {
    public boolean canJump(int[] nums) {
        // we first set final position to the last index, then iterate backwards and check if subsequent jumps lead to the final pos.
        // if the jump at position i leads to the final position, then update finalPos to that index and check if previous index can lead to the finalPos.

        int finalPos = nums.length - 1;
        int i =0;

        for( i = nums.length-2; i>=0; i-- ){
                if( i + nums[i] >= finalPos){
                    finalPos = i;
                }
        } 

        if( finalPos == 0){
            return true;
        }       
        else{
            return false;
        }
    }
}
