class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), ans = 0;

       for(int i=0;i<n;i++){
        ans+= countPalindrome(s,i,i);
        ans+= countPalindrome(s,i,i+1);
       }

       return ans;
    }

    public int countPalindrome(String ss, int left, int right){
        int ans = 0;

        while(left >=0 && right<ss.length()){
            if(ss.charAt(left) != ss.charAt(right)){
                break;
            }

            left--;
            right++;

            ans++;

        }
        return ans;
    }
}
