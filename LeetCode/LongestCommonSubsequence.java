class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        // a c e 0
        // b 0 0 0
        // d 0 0 0
        // c 0 0 0
        // e 0 0 0
        // - 0 0 0
    
    // in the above example, if element at text1[row] == text2[col] then check the diagonal element dp[row+1][col+1]

        for(int i = text1.length()-1; i>=0;i--){
            for(int j= text2.length()-1; j>=0;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1]+1;

                }
                else{
                   dp[i][j]= Math.max(dp[i+1][j],dp[i][j+1]);
                }
                
            }
        }
        return dp[0][0];
    }
}
