class Solution {
    public int coinChange(int[] coins, int amount) {
        return findCoins(0,coins,amount);
    }

    public int findCoins(int idx, int[] coins, int amount){

        //when the total coins fulfill the amount then return 0 
        if(amount==0){
            return 0;
        }

        if(idx < coins.length  && amount>0){
            int maxVal = amount/coins[idx];
            int minCost = Integer.MAX_VALUE;
            
            // i =0 to coins.length is the number of coins used
            for(int i=0;i<=maxVal;i++){
                if(amount>= i*coins[idx]){
                    int res = findCoins(idx+1,coins,amount-i*coins[idx]);

                    if(res!=-1){
                        // we use res+i because this will be the no.of coins returned by the recursive function and the no.of coins in the curent fn.

                        // suppose target is 7 and the coins=[2,1]
                        // if 1 coin of 2 is used then remaining amt = 5. the recursion fn will return 5 to this fun. since 1 coin of 2 is used,,,,
                        // 5+1 will be addded to the result.
                        minCost=Math.min(minCost,res+i);
                    }
                }
            }

            return (minCost == Integer.MAX_VALUE)?-1:minCost;
        }
        return -1;
    }
}
