class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max = 0;
        
        int initCount=0;

        for(int num:nums){
            if(num==k){
                initCount++;
            }
        }

        for(int val=1;val<=50;val++){
            int curFreq = 0;

            int x = val-k;
            if(x==0){
                continue;
            }
            
            int count=0;
            int curMax = 0;

            for(int num:nums){
                if(num==k){
                    count--;
                }
                else if(num==val){
                    count++;
                }
                count = Math.max(count,0);
                curMax = Math.max(curMax, count);

            }

            max = Math.max(max, curMax);
        }
        return max + initCount;
    }
}
