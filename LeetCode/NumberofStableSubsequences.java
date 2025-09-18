class Solution {
    public int countStableSubsequences(int[] nums) {
        
        final int MOD = 1_000_000_007;
        
        long odd1Total = 0;
        long odd2Total = 0;

        long even1Total = 0;
        long even2Total = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2!=0){
                // calculate the subsequences where the current odd number can be added, 1=only the currentNumber, or add the odd num to a sequence of even numbers
                long currOdd1 = (1+even1Total+even2Total)%MOD;

                // for 
                long currOdd2 = odd1Total;

                // calculate
                odd1Total = (odd1Total+currOdd1)%MOD;
                odd2Total = (odd2Total + currOdd2)%MOD; 
            }
            else{
                long currEven1= (1+odd1Total + odd2Total)%MOD;
                long currEven2 = even1Total;

                even1Total = (even1Total + currEven1)%MOD;
                even2Total = (even2Total + currEven2)%MOD;
            }
        }

        long total = (odd1Total+odd2Total+even1Total+even2Total)%MOD;
        return (int)total;
    }
}
