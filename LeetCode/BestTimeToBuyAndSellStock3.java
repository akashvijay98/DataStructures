class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;

        int minVal = prices[0];
        int profit = 0;
        
        for(int i=1;i<n-1;i++){
            if(prices[i]<minVal){
                minVal = prices[i];
            }
            else{
                if(prices[i]>prices[i+1]){
                    profit+= prices[i]-minVal;
                    minVal = prices[i+1];
                }
            }
        }

        profit+= prices[n-1] - minVal;

        return profit>0? profit :0 ;
    }
}
