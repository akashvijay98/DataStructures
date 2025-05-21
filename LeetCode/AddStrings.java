class Solution {
    public String addStrings(String num1, String num2) {

        int l;

        int len1 = num1.length();
        int len2 = num2.length();

        // take the length of the largest String
        l = len1>len2? len1 : len2;

        int idx=  0;
        
        StringBuilder sb = new StringBuilder();
        
        int remainder = 0;
        while(idx<l){
            
            // if index is out of bounds - suppose num1 ="11" and num2 = "123", then idx at 2 will be null for num1
            int n = idx>=len1? 0 : num1.charAt(len1-idx-1)-'0';
            int m = idx>=len2?0:num2.charAt(len2-idx-1)-'0';

            int sum = n+m+remainder;
            //sb.add(sum.toString());

            if(sum>9){
                sb.append(sum%10);
                remainder = sum/10;
            }
            else{
                sb.append(sum);

                // remember to set remainder to 0 if no carry over
                remainder =0;
            }
            idx++;
        }
        if(remainder>0) sb.append(remainder);
        
        // since we are appending to SB, the result will be in reverse order
        return sb.reverse().toString();

        
    }
}
