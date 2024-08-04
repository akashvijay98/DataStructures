class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res=0,count=0;
        for(int num : nums){
            if(num==0){
                count+=1;
            }
            else{
                count =0;
            }
            res+=count;
        }
        return res;
    }
}
