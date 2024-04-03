class Solution {
    public int characterReplacement(String s, int k) {
        int start=0;
        int maxCharFreq=0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0; end<s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+1);

            // take example aabccbb, if suppose end is pointing at index1('a'), so maxCharFreq will be 2.
            // if suppose end is pointing at index 2('b'), so maxCharFreq will still be 2 bcos currnet max freq(a)=2 > freq('b')=1.
            maxCharFreq = Math.max(maxCharFreq, map.get(c));

            // here we subtract the total length of the current string(end-start+1) with maxFreq to get the remaining number of non repeating characters.
            // in example aabccb, if suppose start points to 0('a') and end is pointing at index 3('c'), then ,
            // currentLength(length of aabc = 4) - maxFreq(aa = 2) = 2(non repeating chars b,c)
            // this difference shouldnot exceed K
            while(end-start+1-maxCharFreq>k){
                char startChar = s.charAt(start);
                map.put(startChar,map.get(startChar)-1);
                start++;
            }


            maxLength=Math.max(maxLength, end-start+1);

        }
        return maxLength;
    }
}
