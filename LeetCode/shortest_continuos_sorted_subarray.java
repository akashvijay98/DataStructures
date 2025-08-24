/*
    make a copy of nums array and sort it.
    now compare each element of nums and snums, if they dont match it means the array nums is not in sorted order.
    
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);

        int start = nums.length, end = 0;

        for(int i=0;i<snums.length;i++){
            if(snums[i]!=nums[i]){
                start = Math.min(start, i);
                end = Math.max(end,i);
            }
        }
        return end-start>=0? end-start+1:0;
    }
}
