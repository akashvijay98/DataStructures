class Solution {
    public int minSwaps(String s) {
        int maxLen = 0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(c==']'){
                count++;
            }
            else{
                count--;
            }
            maxLen = Math.max(maxLen,count);
        }

        return (maxLen+1)/2;
    }
}
