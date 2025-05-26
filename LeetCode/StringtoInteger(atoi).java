class Solution {
    int num=0;
    int sign =1;
    boolean isBegin = true;
    public int myAtoi(String s) {
        int sign=1;
        int result = 0;
        int index= 0;
        int n= s.length();

        while(index<n && s.charAt(index)==' '){
            index++;
        }

        if(index<n && s.charAt(index)=='+'){
            sign=1;
            index++;
        }

        
        else if(index<n && s.charAt(index)=='-'){
            sign=-1;
            index++;
        }

        while(index<n && Character.isDigit(s.charAt(index))){
            // convert character to int
            int digit = s.charAt(index)-'0';

            // Check overflow and underflow conditions.

            // if result > maxValue, then multuplying with 10 will make it go out of bounds
            if(result>Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && digit>Integer.MAX_VALUE%10)){
                return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;

            }

            result = result*10+digit;
            index++;
        }

        return sign*result;

    }
}
