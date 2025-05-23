class Solution {
    public String removeDuplicates(String s, int k) {

        StringBuilder sb = new StringBuilder(s);

        int length = -1;

        while(length != sb.length()){
            int count = 1;
            length = sb.length();

            for(int i=0;i<sb.length();i++){
                
                if(i==0 || sb.charAt(i)!=sb.charAt(i-1)){
                    count = 1;

                }
                else {
                    count++;
                }

                if(count == k){
                    sb.delete(i-k+1, i+1);             
                          
                }
                
            }
            count = 1;

        }

        return sb.toString();

                
    }
}
