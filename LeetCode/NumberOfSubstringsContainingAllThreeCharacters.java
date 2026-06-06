class Solution {
    public int numberOfSubstrings(String s) {
        int left=  0;
        int count = 0;

        int[] freq = new int[26];

        int n  = s.length();

        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'a']++;

            while(freq['a'-'a']>0 && freq['b'-'a']>0 && freq['c'-'a']>0){
                count += n-right;

                freq[s.charAt(left)-'a']--;
                left++;
            }
        }

        return count;
    }
}
