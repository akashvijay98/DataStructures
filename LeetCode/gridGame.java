class Solution {
    
    //the first robot can move in both the rows
    // the second robot can either move in top row or the bottom row
    
   
    public long gridGame(int[][] grid) {
        long res=  Long.MAX_VALUE;
        long secondRobot = 0;

        int n = grid[0].length;

        long[] prefix1 = new long[n];
        long[] prefix2 = new long[n];

        long sum1=0,sum2=0;

        for(int i=0;i<n;i++){
            sum1+=grid[0][i];
            prefix1[i]= sum1;

            sum2 += grid[1][i];
            prefix2[i] = sum2;
        }

        for(int i=0;i<n;i++){
            long top = prefix1[n-1] - prefix1[i];

        
            long bottom = i>0? prefix2[i-1] : 0;

            secondRobot = Math.max(top,bottom);
            res= Math.min(res,secondRobot); 
        }

        return res;

    }
        
  
}
