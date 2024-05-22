class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i= 0;i<prices.length;i++){
            //find the minimum value from the array

            //If there are no other elements greater than the min element for example[7,3,4,5,1] 1 in this case, dont need to worry because we already have a maxProfit(5-3).
            if(prices[i]<minBuy){
                minBuy=prices[i];
                
            }
            else{
                // we have already found a minvalue, so we just minus it from the other elements of the array to find the max profit.
                maxProfit=Math.max(maxProfit, prices[i]-minBuy);
            }
        }
        return maxProfit;

    }
}
