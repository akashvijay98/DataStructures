class Solution {
    
    public int coinChange(int[] coins, int amount) {
          if (amount < 1) return 0;
    return dfs(new int[amount], amount, coins);
    }

    public int dfs(int[] count,int rem, int[] coins){
        
        if(rem ==0){
            return 0;
        }
        if(rem<0){
            return -1;
        }
        //memoization
        if (count[rem - 1] != 0) return count[rem - 1];
        
        int min = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = dfs(count, rem-coin, coins);

            if(res >=0 && res<min){
                min = 1+res; 
            }
           
        }
        count[rem-1]= (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }
}
