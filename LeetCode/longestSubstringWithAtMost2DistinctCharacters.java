class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
       int left = 0 ;
       int right = 0;
       int max_len = Integer.MIN_VALUE;

       HashMap<Character,Integer> hashmap = new HashMap<>();

       while(right<s.length()){
        hashmap.put(s.charAt(right),right);
        right++;

        if(hashmap.size()>2){
            int index = Collections.min(hashmap.values());
            hashmap.remove(s.charAt(index));

            left = index+1;
        
        } 
        max_len=Math.max(max_len,right-left);

     }
    return max_len;
    }
}
