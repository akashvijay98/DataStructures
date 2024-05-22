class Solution {
    public int maxProfit(int[] prices) {
        int peak = prices[0];
        int valley = prices[0];
        
        int profit = 0;
        int i=0;
        while(i<prices.length-1){
            while(i<prices.length-1 && prices[i]>=prices[i+1]){
                i++;
            }
            
            valley = prices[i];    
            
            while(i<prices.length-1 && prices[i]<=prices[i+1]){
                i++;
            }
            
            peak = prices[i];
            profit += peak-valley;
        }
        return profit;
       
    }
}
