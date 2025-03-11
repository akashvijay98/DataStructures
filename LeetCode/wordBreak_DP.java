class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n= s.length();
        boolean[] dp = new boolean[n];
        
        // check if each index i is either equal to word.length from wordDict, example: i=3, s.substring(0,4) = "leet"
        //    or 
        // if dp[i-word.length()] is true example : s is "leetcode" and wordDict={"leet","code"} and i = 7 s[7]= 'e' then
        //   since i-word.length = 7-4 = 3 and index i=0 to 3 = "leet" and it exists in wordDict, dp[3] = true 
        //so we proceed to check substring(4,8) i.e "code" and check if it exists in wordDict
 
        for(int i=0;i<n;i++){
            for(String word :wordDict){
                if( i>=word.length() && dp[i-word.length()] || i==word.length()-1  ){
                    if(s.substring(i-word.length()+1,i+1).equals(word)){
                        dp[i]=true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];

    }
}
