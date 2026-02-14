
/*
    step 1: we generate all possible substrings for both strings and add them to seperate lists.
    step 2: we then check for palindromes against all possible combinations of substrings in both lists.
    step 3. we then find the longest palindromes out of all

*/

class Solution {
    public int longestPalindrome(String s, String t) {
        List<String> sList = generateAllPossibleSubstrings(s);
        List<String> tList = generateAllPossibleSubstrings(t);

        int maxLen = 0;

        for(String subStr1:sList){
            for(String subStr2:tList){
                String combined = subStr1+subStr2;
                if(isPalindrome(combined)){
                    maxLen = Math.max(maxLen,combined.length());
                }
            }
        }
        return maxLen;
    }

    private List<String> generateAllPossibleSubstrings(String str){
        int len = str.length();
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<=len;j++){
                list.add(str.substring(i,j));
            }
        }
        // we add empty string to list because in some cases the longest palindrome might come from one substring, so we keep an empty string
        list.add("");
        return list;
     
    }

    private boolean isPalindrome(String str){
        int start = 0;
        int end= str.length()-1;

        while(start<end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

}
