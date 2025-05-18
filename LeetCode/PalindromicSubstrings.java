class Solution {
    int count=0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){

            // to count odd number palindromes
            isPalindrome(s,i,i);

            // to count even number palindromes
            isPalindrome(s,i,i+1);
           
        }
         return count;
    }

    private void isPalindrome(String s, int i, int j){
        while(i>=0 && j<s.length()){
            if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))){
                break;
            }

            count++;

            i--;
            j++;
        }
     
    }

   
}
