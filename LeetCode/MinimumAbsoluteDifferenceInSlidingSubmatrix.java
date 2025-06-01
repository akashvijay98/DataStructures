class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m= grid.length;
        int n = grid[0].length;
        
        int[][] ans = new int[m-k+1][n-k+1];

        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){

                // TreeSet stores values in a sorted manner
                TreeSet<Integer> values = new TreeSet<>();

                for(int r=i;r<i+k;r++){
                    for(int c=j;c<j+k;c++){
                        values.add(grid[r][c]);
                    }
                }

                if(values.size()<=1){
                    ans[i][j]=0;
                    continue;
                }
                int minDiff = Integer.MAX_VALUE;

                Integer prev= null;

                for(int val:values){
                    if(prev!=null){
                        minDiff= Math.min(minDiff, val-prev);
                        
                    }

                    prev=val;
                }
                ans[i][j] = minDiff;
            }
            
        }
        return ans;
    }
}©leetcode
