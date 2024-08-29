


class Solution {
    public String longestPalindrome(String s) {
        for(int length=s.length();length>0;length--){
            for(int start = 0;start<=s.length();start++){

                /*
                    This is how the nested loops works in the code
                    For s = "babad" (length = 5):

                    Outer Loop (length = 5):
                    Inner loop (start = 0): Check "babad".
                    Outer Loop (length = 4):
                    Inner loop (start = 0): Check "baba".
                    Inner loop (start = 1): Check "abad".
                    Outer Loop (length = 3):
                    Inner loop (start = 0): Check "bab".
                    Inner loop (start = 1): Check "aba".
                    Inner loop (start = 2): Check "bad".
                */


                // check the boundary i.e start + length should not exceed the length of the string
                if (start + length <= s.length()) {
                    if(isPalindrome(start,start+length,s)){
                        return s.substring(start,start+length);
                    }
                }
            }
        }
        return "";
    }

    boolean isPalindrome(int i, int j, String s){
        int left = i;
        int right = j-1;

        while(left< right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
